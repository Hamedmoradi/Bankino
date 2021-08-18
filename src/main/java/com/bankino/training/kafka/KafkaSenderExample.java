//package com.bankino.training.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//
//@Component
//class KafkaSenderExample {
//private KafkaTemplate<String, String> kafkaTemplate;
//private static final Logger log = LoggerFactory.getLogger(KafkaSenderExample.class);
//
//@Autowired
//KafkaSenderExample(KafkaTemplate<String, String> kafkaTemplate) {
//	this.kafkaTemplate = kafkaTemplate;
//
//}
//
//void sendMessage(String message, String topicName) {
//	kafkaTemplate.send(topicName, message);
//}
//@Scheduled(fixedRate = 6000)
//void sendMessageWithCallback() {
//	ListenableFuture<SendResult<String, String>> future =
//			kafkaTemplate.send("testTopic", "messageasdasdasdasdasd");
//
//	future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//		@Override
//		public void onSuccess(SendResult<String, String> result) {
//			log.info("Message [{}] delivered with offset {}",
//					"messageasdasdasdasdasdasdasdasd",
//					result.getRecordMetadata().offset());
//		}
//
//		@Override
//		public void onFailure(Throwable ex) {
//			log.warn("Unable to deliver message [{}]. {}",
//					"messageasdasdasdasdasdasdasdasd",
//					ex.getMessage());
//		}
//	});
//}
//
//public void asd() {
//	try {
//		ListenableFuture<SendResult<String, String>> future =
//				kafkaTemplate.send("testTopic", "messageasdasdasdasdasd");
//	}catch (Exception e){
//		e.printStackTrace();
//	}
//}
//}