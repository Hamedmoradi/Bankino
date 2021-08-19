package com.bankino.training.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
public class KafkaProducerConfig {

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