package com.mesh.controller;

import com.mesh.dto.LoginRequest;
import com.mesh.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mesh.dto.RegisterUserRequest;
import com.mesh.entity.User;
import com.mesh.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody RegisterUserRequest request) {

        return userService.registerUser(
                request.getName(),
                request.getPhone(),
                request.getPassword()
        );
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){

        return userService.loginUser(request.getPhone(), request.getPassword());

    }
}
