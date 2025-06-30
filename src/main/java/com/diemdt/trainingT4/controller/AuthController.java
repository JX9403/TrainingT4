package com.diemdt.trainingT4.controller;

import com.diemdt.trainingT4.model.User;
import com.diemdt.trainingT4.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "API Register", description = "API Đăng ký")
public class AuthController {
    private final UserService userService;
    @Operation(summary = "Đăng ký - nhập email - password")
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

}