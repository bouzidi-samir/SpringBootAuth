package com.template.authentication.authentication.controller;

import com.template.authentication.authentication.model.AuthenticationRequest;
import com.template.authentication.authentication.model.AuthenticationResponse;
import com.template.authentication.authentication.model.RegisterRequest;
import com.template.authentication.authentication.model.User;
import com.template.authentication.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ) {
        return  ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ) {
        return  ResponseEntity.ok(authService.authenticate(request));
    }

}
