package com.example.spring_study.controller;

import com.example.spring_study.domain.User;
import com.example.spring_study.repository.UserRepository;
import com.example.spring_study.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User API", description = "Operations pertaining to user management")
public class UserController {

    private final UserService userService;

    /**
     * Returns a view (userList) populated with the list of users.
     *
     * @param model the model to hold attributes for the view
     * @return the name of the view to be rendered
     */
    @Operation(summary = "Get user list (view-based)",
            description = "Retrieves all users and returns the userList view.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the view with user list"),
            @ApiResponse(responseCode = "403", description = "Forbidden: you do not have the necessary permissions"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userList"; // "userList" view
    }

    /**
     * Creates a new user from JSON data in the request body, then returns the userList view.
     *
     * @param user the user data from the request body
     * @param model the model to hold attributes for the view
     * @return the name of the view to be rendered
     */
    @Operation(summary = "Create a new user (view-based)",
            description = "Saves the user from request body and returns the userList view.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully, view returned"),
            @ApiResponse(responseCode = "400", description = "Bad request: invalid user data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/users")
    public String createUser(@RequestBody User user, Model model) {
        User savedUser = userService.save(user);
        model.addAttribute("user", savedUser);
        return "userList";
    }

    /**
     * Retrieves the list of users as JSON data (RESTful style).
     *
     * @return a list of users in JSON format
     */
    @Operation(summary = "Get user list (JSON)",
            description = "Retrieves all users and returns them as JSON.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of users in JSON"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/json-users")
    public List<User> getUsers() {
        return userService.findAll();
    }
}