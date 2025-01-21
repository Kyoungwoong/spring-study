package com.example.spring_study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {

    private static final Logger logger = LoggerFactory.getLogger(SlackService.class);
    private final String webhookUrl = "webhookUrl";

    public void sendSlackNotification(String message) {
        RestTemplate restTemplate = new RestTemplate();

        // Slack 메시지 포맷
        String payload = String.format("{\"text\":\"%s\"}", message);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        try {
            // Slack으로 요청 보내기
            ResponseEntity<String> response = restTemplate.exchange(
                    webhookUrl,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                logger.info("Slack notification sent successfully!");
            } else {
                logger.error("Failed to send Slack notification. Status code: {}", response.getStatusCode());
            }

        } catch (HttpClientErrorException e) {
            logger.error("Slack API error: {}", e.getResponseBodyAsString(), e);
        } catch (Exception e) {
            logger.error("Unexpected error while sending Slack notification", e);
        }
    }
}

