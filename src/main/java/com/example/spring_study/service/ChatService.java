package com.example.spring_study.service;

import com.example.spring_study.domain.Chat;
import com.example.spring_study.domain.ChatRoom;
import com.example.spring_study.repository.ChatRepository;
import com.example.spring_study.repository.ChatRoomRepository;
import com.example.spring_study.repository.FilterDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository roomRepository;
    private final ChatRepository chatRepository;
    private final FilterDataRepository filterDataRepository;

    public List<ChatRoom> findAllRoom() {
        return roomRepository.findAll();
    }

    public ChatRoom findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    public ChatRoom createRoom(String name) {
        return roomRepository.save(ChatRoom.createRoom(name));
    }

    public Chat createChat(Long roomId, String sender, String senderEmail, String message) {
        ChatRoom room = roomRepository.findById(roomId).orElseThrow();  // 방 찾기 -> 없는 방일 경우 여기서 예외처리

        Chat chat = Chat.createChat(room, sender, senderEmail, message);
        
        return chatRepository.save(chat);
    }


    // 채팅방 채팅내용 불러오기
    public List<Chat> findAllChatByRoomId(Long roomId) {
        return chatRepository.findAllByRoomId(roomId);
    }

    public ChatRoom createChatRoom(String roomName) {
        ChatRoom newRoom = ChatRoom.builder()
                .name(roomName)
                .build();

        roomRepository.save(newRoom); // DB에 저장
        return newRoom;
    }
}