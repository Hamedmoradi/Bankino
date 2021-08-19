package com.bankino.training.kafka;//package com.bankino.training.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
@Configuration
public class KafkaConsumerConfig {
    private static Properties   kafkaProps;
    private static Consumer<String, String> kafkaConsumer;

    static {
        kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("group.id", "bankino_group_id");
        kafkaConsumer = new KafkaConsumer<>(kafkaProps);
    }
@KafkaListener(topics = "testTopic",groupId = "bankino_group_id")
    public ConsumerRecords<String, String> consumeMessage(String topic) {
        kafkaConsumer.subscribe(Collections.singletonList(topic));
        Duration duration = Duration.ofSeconds(10l);
        while (true) {
            return kafkaConsumer.poll(duration);
        }

    }




}