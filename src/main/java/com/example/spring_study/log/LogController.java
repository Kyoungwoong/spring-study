package com.example.spring_study.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // Logger 객체 자동 생성
@RestController
public class LogController {

    @GetMapping("/log")
    public String logExample(@RequestParam String message) {
        log.info("INFO 로그: {}", message);
        log.warn("WARN 로그: {}", message);
        log.error("ERROR 로그: {}", message);
        return "로그 출력 완료!";
    }
}