package com.domain.project.user.controller;

import com.domain.project.user.dto.AuthRequest;
import com.domain.project.user.dto.RegisterRequest;
import com.domain.project.user.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest request) {
        String token = authenticationService.register(request);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Valid AuthRequest request) {
        String token = authenticationService.authenticate(request);
        return ResponseEntity.ok(token);
    }
}
