//package com.example.spring_study.controller;
//
//import com.example.spring_study.domain.Message;
//import com.example.spring_study.service.KafkaConsumerService;
//import com.example.spring_study.service.KafkaProducerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/kafka")
//public class KafkaController {
//
//    private final KafkaProducerService producerService;
//    private final KafkaConsumerService consumerService;
//
//    @PostMapping("/send")
//    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
//        String topic = "test-topic"; // 전송할 토픽 이름
//        producerService.sendMessage(topic, message);
//        return ResponseEntity.ok("Message sent to Kafka topic: " + topic);
//    }
//
//    @GetMapping("/consume")
//    public ResponseEntity<List<String>> consumeMessages() {
//        // ConsumerService에서 메시지를 가져옴
//        List<String> messages = consumerService.getMessages();
//        return ResponseEntity.ok(messages);
//    }
//}