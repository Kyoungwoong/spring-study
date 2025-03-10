package com.example.spring_study.json.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonIgnoreType
    static class SecretData {
        public String key = "secret";
    }
    private String username;
    private String email;

//    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 역직렬화만 허용
    private String password; // JSON 변환 시 제외됨

//    public SecretData secretData = new SecretData();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}