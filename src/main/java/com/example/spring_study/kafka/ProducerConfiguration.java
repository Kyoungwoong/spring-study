//package com.example.spring_study.kafka;
//
//import com.example.spring_study.domain.Message;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//public class ProducerConfiguration {
//
//    // Kafka ProducerFactory를 생성하는 Bean 메서드
//    @Bean
//    public ProducerFactory<String, Message> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigurations());
//    }
//
//    // Kafka Producer 구성을 위한 설정값들을 포함한 맵을 반환하는 메서드
//    @Bean
//    public Map<String, Object> producerConfigurations() {
//        return Map.of(
//                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
//                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
//                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
//            );
//    }
//
//    // KafkaTemplate을 생성하는 Bean 메서드
//    @Bean
//    public KafkaTemplate<String, Message> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}