package com.example.spring_study.config;

import com.example.spring_study.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
//@RequiredArgsConstructor // 이게 필요한가?
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/send"); // 클라이언트에서 보낸 메세지를 받을 prefix
        registry.enableSimpleBroker("/room");    // 해당 주소를 구독하고 있는 클라이언트들에게 메세지 전달
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // ws://localhost:8080/ws-stomp
        registry.addEndpoint("/ws-stomp") // SockJS 연결주소
                .setAllowedOriginPatterns("*")
                .withSockJS(); // 버전 낮은 브라우저에서도 적용 가능.
    }
}
