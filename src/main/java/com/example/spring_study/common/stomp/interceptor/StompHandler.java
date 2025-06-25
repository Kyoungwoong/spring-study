//package com.example.spring_study.config;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE + 99)
//public class StompHandler implements ChannelInterceptor {
//
//    @Override
//    public Message<?> preSend(Message<?> message, MessageChannel messageChannel) {
//
//        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//        System.out.println("presend: " + 1);
////        if (StompCommand.CONNECT == accessor.getCommand()) {
////            String authorizationHeader = accessor.getFirstNativeHeader("Authorization");
////            System.out.println(2 + ": " + authorizationHeader);
////            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
////                log.warn("No Authorization header or not Bearer type");
////                return null;
////            }
////
////            String token = authorizationHeader.split(" ")[1];
////            System.out.println(3 + ": " + token);
////        }
////
////        System.out.println(message.getPayload());
//
//        return message;
//    }
//}
