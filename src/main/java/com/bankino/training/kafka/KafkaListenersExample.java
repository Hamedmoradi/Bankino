//package com.bankino.training.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//class KafkaListenersExample {
//
//Logger LOG = LoggerFactory.getLogger(KafkaListenersExample.class);
//
//@KafkaListener(topics = "testTopic")
//void listener(String data) {
//	LOG.info(data);
//}
//
//@KafkaListener(
//		topics = "testTopic"
////		,
////		groupId = "reflectoring-group-2"
//		)
//void commonListenerForMultipleTopics(String message) {
//	LOG.info("MultipleTopicListener - {}", message);
//}
//}