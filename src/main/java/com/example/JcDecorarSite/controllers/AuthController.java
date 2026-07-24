package com.example.JcDecorarSite.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JcDecorarSite.dto.request.UserRequestDTO;
import com.example.JcDecorarSite.dto.response.LoginResponseDTO;
import com.example.JcDecorarSite.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody UserRequestDTO dto) {

        return ResponseEntity.ok(
                authService.login(dto));
    }
}