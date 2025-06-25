package com.example.spring_study.repository;

import com.example.spring_study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();

    Optional<Member> findByUsername(String username);
}
