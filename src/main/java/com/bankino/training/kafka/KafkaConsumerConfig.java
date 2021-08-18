package com.bankino.training.kafka;//package com.bankino.training.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//class KafkaConsumerConfig {
//
//@Value("${spring.kafka.consumer.bootstrap-servers}")
//private String bootstrapServers;
//
//@Value("${spring.kafka.consumer.groupid}")
//private String groupId;
//
//@Bean
//public ConsumerFactory<String, String> consumerFactory() {
//	Map<String, Object> props = new HashMap<>();
//	props.put(
//			ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
//			bootstrapServers);
//	props.put(
//			ConsumerConfig.GROUP_ID_CONFIG,
//			groupId);
//	props.put(
//			ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//			StringDeserializer.class);
//	props.put(
//			ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//			StringDeserializer.class);
//	return new DefaultKafkaConsumerFactory<>(props);
//}
//
//@Bean
//public ConcurrentKafkaListenerContainerFactory<String, String>
//kafkaListenerContainerFactory() {
//
//	ConcurrentKafkaListenerContainerFactory<String, String> factory =
//			new ConcurrentKafkaListenerContainerFactory<>();
//	factory.setConsumerFactory(consumerFactory());
//	return factory;
//}
//}

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.retrytopic.DestinationTopic;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
@Component
public class KafkaConsumerConfig {
    private static Properties kafkaProps;
    private static Consumer<String, String> kafkaConsumer;

    static {
        kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaProps.put("group.id", "testGroup");
        kafkaProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        kafkaConsumer = new KafkaConsumer<String, String>(kafkaProps);
    }

    public ConsumerRecords<String, String> consumeMessage(String topic) throws InterruptedException {
        kafkaConsumer.subscribe(Collections.singletonList(topic));
        Duration duration = Duration.ofSeconds(10l);
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(duration);
            return records;
        }

    }




}