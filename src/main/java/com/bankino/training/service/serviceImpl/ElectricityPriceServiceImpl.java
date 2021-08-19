package com.bankino.training.service.serviceImpl;

import com.bankino.training.domain.CounterReport;
import com.bankino.training.domain.ElectricityRate;
import com.bankino.training.repository.ConfigRepository;
import com.bankino.training.repository.CounterReportRepository;
import com.bankino.training.repository.ElectricityRateRepository;
import com.bankino.training.service.ElectricityPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ElectricityPriceServiceImpl implements ElectricityPriceService {

    public static final Logger logger = LoggerFactory.getLogger(ElectricityPriceServiceImpl.class);

    @Autowired
    private final CounterReportRepository counterReportRepository;
    @Autowired
    private final ConfigRepository configRepository;
    @Autowired
    private final ElectricityRateRepository electricityRateRepository;

    public ElectricityPriceServiceImpl(CounterReportRepository counterReportRepository, ConfigRepository configRepository, ElectricityRateRepository electricityRateRepository) {
        this.counterReportRepository = counterReportRepository;
        this.configRepository = configRepository;
        this.electricityRateRepository = electricityRateRepository;
    }


    @Override
    public String calculatePeriodicCounterPrice(Date startDate, Date endDate, Long counterId) {
        List<CounterReport> counterReportList = counterReportRepository.findAllNotCalculatedReports(startDate, endDate, counterId);
        BigDecimal totalUsage = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal cost = BigDecimal.ZERO;
        for (CounterReport counterReport : counterReportList) {
            totalUsage = counterReport.getUsage().add(totalUsage);
            ElectricityRate electricityRate =
                    electricityRateRepository.findByGeographicalAreaCounterId(counterReport.getGeographicalAreaCounter().getId());
            BigDecimal regionCost = electricityRate.getPrice();
            if (counterReport.getHour() >= 0 && counterReport.getHour() < 9) {
                cost = counterReport.getUsage().multiply(BigDecimal.valueOf(1)).multiply(regionCost);
            } else if (counterReport.getHour() >= 9 && counterReport.getHour() < 15) {
                cost = counterReport.getUsage().multiply(BigDecimal.valueOf(1.1)).multiply(regionCost);
            } else if (counterReport.getHour() >= 15 && counterReport.getHour() < 21) {
                cost = counterReport.getUsage().multiply(BigDecimal.valueOf(1.2)).multiply(regionCost);
            } else if (counterReport.getHour() >= 21 && counterReport.getHour() < 24) {
                cost = counterReport.getUsage().multiply(BigDecimal.valueOf(1)).multiply(regionCost);
            }
            totalCost = totalCost.add(cost);

        }
        if (totalUsage.compareTo(BigDecimal.valueOf(800)) == 1) {
            totalCost.add(BigDecimal.valueOf(800));
        }
        logger.info("totalCost:" + totalCost + "----totalUsage:" + totalUsage);
        return "totalCost:" + totalCost + "totalUsage:" + totalUsage;
    }


}
