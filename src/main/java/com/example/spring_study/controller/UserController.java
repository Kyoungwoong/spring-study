package com.example.spring_study.controller;

import com.example.spring_study.domain.User;
import com.example.spring_study.repository.UserRepository;
import com.example.spring_study.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList"; // "userList" 뷰 반환
    }

    /**
     * Handles POST requests to create a new user.
     *
     * @param user the user data from the request body
     * @param model the model to hold attributes for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/users")
    public String createUser(@RequestBody User user, Model model) {
        User savedUser = userService.save(user);
        model.addAttribute("user", savedUser);
        return "userList"; // Return the name of the view
    }

    /**
     * Handles GET requests to retrieve the list of users as JSON.
     *
     * @return a list of users
     */
    @GetMapping("/json-users")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
