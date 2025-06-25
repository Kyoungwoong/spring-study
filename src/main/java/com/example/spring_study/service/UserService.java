package com.example.spring_study.service;

import com.example.spring_study.domain.Member;
import com.example.spring_study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Member> findAll() {
        log.info("Service: findAll");
        return userRepository.findAll();
    }

    public Member save(Member member) {
        return userRepository.save(member);
    }
}
