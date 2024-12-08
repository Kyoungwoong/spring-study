package com.example.spring_study.controller;

import com.example.spring_study.domain.Chat;
import com.example.spring_study.domain.ChatRoom;
import com.example.spring_study.dto.ChatMessage;
import com.example.spring_study.dto.FilterDataRequest;
import com.example.spring_study.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@CrossOrigin(allowCredentials = "true", originPatterns = "*")
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/{roomId}") //여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    @SendTo("/room/{roomId}")   //구독하고 있는 장소로 메시지 전송 (목적지)  -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
    public ChatMessage chat(@DestinationVariable Long roomId, ChatMessage message) {
        log.info("chat: {}: {}{}", LocalDateTime.now(), roomId, message);

        //채팅 저장
        Chat chat = chatService.createChat(roomId, message.getSender(), message.getSenderEmail(), message.getMessage());
        return ChatMessage.builder()
                .roomId(roomId)
                .sender(chat.getSender())
                .senderEmail(chat.getSenderEmail())
                .message(chat.getMessage())
                .build();
    }

    @PostMapping("/chat/room")
    @ResponseBody
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody String roomName) {
        log.info("createChatRoom: {}", roomName);

        // 채팅 룸 생성
        ChatRoom newRoom = chatService.createChatRoom(roomName);

        return ResponseEntity.ok(newRoom);
    }

    @GetMapping("/chat/room")
    @ResponseBody
    public ResponseEntity<List<ChatRoom>> getChatRoom() {
        log.info("get Room");

        List<ChatRoom> chatRooms = chatService.findAllRoom();

        return ResponseEntity.ok(chatRooms);
    }
}