package com.example.spring_study.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.example.spring_study.domain.MemberRole.USER;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(nullable = false, length = 60) // 패스워드 인코딩(BCrypt)
    private String password; // 비밀번호

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole role = USER;


    public Member(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Member(String username, String email, String password, MemberRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}