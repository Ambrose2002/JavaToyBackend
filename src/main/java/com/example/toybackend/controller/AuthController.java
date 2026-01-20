package com.example.toybackend.controller;

import com.example.toybackend.security.JwtUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return JwtUtil.generateToken("user");
    }
}
