//package com.example.spring_study.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class KafkaConsumerService {
//
//    private final List<String> messageStorage = new ArrayList<>();
//
//    @KafkaListener(topics = "test-topic", groupId = "test-group")
//    public void listen(String message) {
//        log.info("Received message: {}", message);
//        synchronized (messageStorage) {
//            messageStorage.add(message); // 메시지를 저장
//            if (messageStorage.size() > 100) { // 메시지가 많아지면 일정 수를 초과하지 않도록 제거
//                messageStorage.remove(0);
//            }
//        }
//    }
//
//    public List<String> getMessages() {
//        synchronized (messageStorage) {
//            return new ArrayList<>(messageStorage); // 메시지 복사본 반환
//        }
//    }
//}
