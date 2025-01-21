package com.example.spring_study.controller;

import com.example.spring_study.dto.InquiryRequest;
import com.example.spring_study.service.SlackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inquiry")
public class InquiryController {

    private final SlackService slackService;

    @PostMapping
    public String handleInquiry(@RequestBody InquiryRequest inquiryRequest) {
        // 요청 처리 로직
        String message = String.format(
                "새로운 문의가 도착했습니다! \n이름: %s\n이메일: %s\n내용: %s",
                inquiryRequest.getName(),
                inquiryRequest.getEmail(),
                inquiryRequest.getMessage()
        );

        // Slack 알림을 비동기로 전송
        slackService.sendSlackNotification(message);

        return "문의가 접수되었습니다.";
    }
}

