package com.example.JcDecorarSite.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.JcDecorarSite.dto.request.UserRequestDTO;
import com.example.JcDecorarSite.dto.response.LoginResponseDTO;
import com.example.JcDecorarSite.dto.response.UserResponseDTO;
import com.example.JcDecorarSite.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO login(UserRequestDTO dto) {

        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                dto.email(),
                dto.password());

        Authentication authentication = authenticationManager.authenticate(usernamePassword);

        String token = jwtService.generateToken(
                authentication.getName());

        return new LoginResponseDTO(token);
    }
}