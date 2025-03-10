//package com.example.spring_study.service;
//
//import com.example.spring_study.domain.Message;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class KafkaListenerService {
//
//    @KafkaListener(topics = "test-topic", groupId = "adopt", containerFactory = "kafkaListenerContainerFactory")
//    public void listen(Message message) {
//        log.info("Received message: {}", message);
//    }
//}