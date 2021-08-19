package com.bankino.training.service.serviceImpl;

import com.bankino.training.domain.Counter;
import com.bankino.training.domain.CounterReport;
import com.bankino.training.domain.GeographicalAreaCounter;
import com.bankino.training.enums.CounterStatus;
import com.bankino.training.enums.EmailTemplateContent;
import com.bankino.training.exception.ReportFromInactiveCounterException;
import com.bankino.training.kafka.KafkaConsumerConfig;
import com.bankino.training.repository.CounterReportRepository;
import com.bankino.training.repository.CounterRepository;
import com.bankino.training.repository.GeographicalAreaCounterRepository;
import com.bankino.training.service.CounterReportService;
import com.bankino.training.service.EmailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
@Transactional
public class CounterReportServiceImpl implements CounterReportService {

    public static final Logger logger = LoggerFactory.getLogger(CounterReportServiceImpl.class);


    private final CounterReportRepository counterReportRepository;
    private final CounterRepository counterRepository;
    private final GeographicalAreaCounterRepository geographicalAreaCounterRepository;
    private final EmailService emailService;



    public CounterReportServiceImpl(CounterReportRepository counterReportRepository, CounterRepository counterRepository,
                                    GeographicalAreaCounterRepository geographicalAreaCounterRepository, EmailService emailService) {
        this.counterReportRepository = counterReportRepository;
        this.counterRepository = counterRepository;
        this.geographicalAreaCounterRepository = geographicalAreaCounterRepository;
        this.emailService = emailService;
    }


    @Override
    public void registerCounterReport(String jsonMessage) throws ParseException {
        JSONObject json = new JSONObject(jsonMessage);
        Counter counter = counterRepository.getOne(json.getLong("counterId"));
        GeographicalAreaCounter geographicalAreaCounter =
                geographicalAreaCounterRepository.getOne(json.getLong("GeographicalAreaCounterId"));
        CounterReport report = new CounterReport();
        report.setCounter(counter);
        report.setGeographicalAreaCounter(geographicalAreaCounter);
        Date startDate = null;
        Date endDate = null;
        try{
        if (counter.getStatus().equals(CounterStatus.INACTIVE.getResultCode())) {
            emailService.sendEmail(EmailTemplateContent.INACTIVE_COUNTER.getContext()+":"+counter.getId().toString());
            throw new ReportFromInactiveCounterException(counter.getId().toString());
        }

                startDate = getDateFromJson(json, "startDate");
                if (json.has("endDate")) {
                    report.setEndDate(getDateFromJson(json, "endDate"));
                } else {
                    report.setEndDate(null);
                }
            report.setStartDate(startDate);

            report.setHour(json.getInt("hour"));
            report.setUsage(json.getBigDecimal("usage"));
            report.setSendConfirmationData(true);

            counterReportRepository.save(report);

        }
        catch(ReportFromInactiveCounterException e){
            e.printStackTrace();
        }
    }
    private Date getDateFromJson(JSONObject json, String key) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        return format.parse((json.getString(key)));
    }

    public void listOfMessages(ConsumerRecords<String, String> records) {
        if (records.count() == 0) {
            logger.info("empty messages");
        }
        for (ConsumerRecord<String, String> record : records) {
            logger.info("topic=%s,partition=%s,key=%s,value=%s\n", record.topic(), record.partition(), record.key(), record.value());
            try {
                registerCounterReport(record.value());
            } catch (ParseException e) {
                continue;
            }
        }
    }

    @Scheduled(fixedRate = 60000)
    public void finalConsume() throws InterruptedException {
        KafkaConsumerConfig kafka = new KafkaConsumerConfig();
        ConsumerRecords<String, String> records = kafka.consumeMessage("testTopic");
        listOfMessages(records);


    }
}
