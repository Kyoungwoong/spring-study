package com.example.spring_study.common.security.service;

import com.example.spring_study.common.exception.ErrorCode;
import com.example.spring_study.common.exception.SpringStudyException;
import com.example.spring_study.domain.Member;
import com.example.spring_study.domain.UserDetailsImpl;
import com.example.spring_study.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userRepository.findByUsername(username)
                .orElseThrow(() -> new SpringStudyException(ErrorCode.USER_NOT_FOUND));

        return UserDetailsImpl.build(member);
    }
}
