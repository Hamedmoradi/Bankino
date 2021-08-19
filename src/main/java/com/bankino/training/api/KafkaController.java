package com.bankino.training.api;

import com.bankino.training.kafka.KafkaProducerConfig;
import com.bankino.training.service.serviceImpl.CounterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


@RestController
@RequestMapping(value = "/kafka")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to kafka Entity!!!!")
public class KafkaController {
    public static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaProducerConfig producer;

    @Autowired
    public KafkaController(KafkaProducerConfig producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    @ApiOperation(value = "kafka", response = Iterable.class)
    public void sendMessageToKafkaTopic() {

        try {
            File file = new File("src/main/resources/counterData.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
                this.producer.sendMessage(line);
            }
            logger.debug("Contents of File: ");
            logger.debug(String.valueOf(sb));
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}