//package com.example.spring_study.service;
//
//import com.example.spring_study.domain.Message;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class KafkaProducerService {
//
//    private final KafkaTemplate<String, Message> kafkaTemplate;
//
//    // 메시지 전송 메서드
//    public void sendMessage(String topic, Message message) {
//        kafkaTemplate.send(topic, message);
//        log.info("Sent message: {} to topic: {}", message, topic);
//    }
//}
