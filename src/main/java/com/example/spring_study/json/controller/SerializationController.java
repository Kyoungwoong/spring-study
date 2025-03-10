package com.example.spring_study.json.controller;

import com.example.spring_study.json.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serialization")
public class SerializationController {

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        User user = new User("testUser", "securePassword");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok("User created: " + user.getUsername());
    }
}
