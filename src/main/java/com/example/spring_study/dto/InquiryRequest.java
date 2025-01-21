package com.example.spring_study.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquiryRequest {
    private String name;
    private String email;
    private String message;

}
