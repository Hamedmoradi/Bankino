package com.bankino.training.kafka;
//
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.ProducerListener;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//@Configuration
//class KafkaProducerConfig {
//private static final Logger log = LoggerFactory.getLogger(KafkaProducerConfig.class);
//
//@Value("${spring.kafka.producer.bootstrap-servers}")
//private String bootstrapServers;
//
//@Bean
//KafkaTemplate<String, String> kafkaTemplate() {
//	KafkaTemplate<String, String> kafkaTemplate =
//			new KafkaTemplate<>(producerFactory());
//	kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
//		@Override
//		public void onSuccess(
//				ProducerRecord<String, String> producerRecord,
//				RecordMetadata recordMetadata) {
//
//			log.info("ACK from ProducerListener message: {} offset:  {}",
//					producerRecord.value(),
//					recordMetadata.offset());
//		}
//	});
//	return kafkaTemplate;
//}
//
//@Bean
//public Map<String, Object> producerConfigs() {
//	Map<String, Object> props = new HashMap<>();
//	props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//			bootstrapServers);
//	props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//			StringSerializer.class);
//	props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//			StringSerializer.class);
//	props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//	return props;
//}
//
//@Bean
//public ProducerFactory<String, String> producerFactory() {
//	return new DefaultKafkaProducerFactory<>(producerConfigs());
//}
//
//}
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Properties;

@Configuration
public class KafkaProducerConfig {

	private static Properties kafkaProps;
	private static Producer<String, String> kafkaProducer;

	static {
		kafkaProps = new Properties();
		kafkaProps.put("bootstrap.servers", "localhost:9092");
		kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		kafkaProps.put("group.id", "testGroup");
		kafkaProps.put("acks","all");
		kafkaProducer = new KafkaProducer<String, String>(kafkaProps);
	}

private static final Logger logger = LoggerFactory.getLogger(KafkaProducerConfig.class);
private static final String TOPIC = "testTopic";

private final KafkaTemplate<String,String> kafkaTemplate;

	public KafkaProducerConfig(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message){
	logger.info(String.format("$$$ -> Producing message --> %s",message));


	ListenableFuture<SendResult<String, String>> future =
			this.kafkaTemplate.send(TOPIC,message);
//		try{
//
//				RecordMetadata ack = kafkaProducer.send(new ProducerRecord<String, String>("replicated_topic", Integer.toString(i), "MyMessage" + Integer.toString(i))).get();
//				System.out.println(" Offset = " + ack.offset());
//				System.out.println(" Partition = " + ack.partition());
//
//		} catch (Exception ex){
//			ex.printStackTrace();
//		} finally {
//			kafkaProducer.close();
//		}
	future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
		@Override
		public void onSuccess(SendResult<String, String> result) {
			logger.info("Message [{}] delivered with offset {}",
					message,
					result.getRecordMetadata().offset());
		}

		@Override
		public void onFailure(Throwable ex) {
			logger.warn("Unable to deliver message [{}]. {}",
					message,
					ex.getMessage());
		}
	});

}

}