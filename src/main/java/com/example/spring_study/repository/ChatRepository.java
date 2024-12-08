package com.example.spring_study.repository;

import com.example.spring_study.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAllByRoomId(Long roomId);
}
