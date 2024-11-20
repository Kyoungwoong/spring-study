package com.example.spring_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Security 비활성화
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);
	}

}
