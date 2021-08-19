package com.bankino.training.api;

import com.bankino.training.kafka.KafkaProducerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping(value = "/kafka")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to kafka Entity!!!!")
public class KafkaController {

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
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                this.producer.sendMessage(line);
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}