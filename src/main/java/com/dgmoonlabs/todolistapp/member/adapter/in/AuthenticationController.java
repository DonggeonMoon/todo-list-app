package com.dgmoonlabs.todolistapp.member.adapter.in;

import com.dgmoonlabs.todolistapp.common.response.ApiResponse;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.AuthenticationRequest;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.AuthenticationResponse;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.RefreshTokenRequest;
import com.dgmoonlabs.todolistapp.member.application.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse.Response<AuthenticationResponse>> requestTokens(@RequestBody AuthenticationRequest request) {
        return ApiResponse.success(
                AuthenticationResponse.of(
                        jwtService.generateAccessToken(request.getUsername(), request.getPassword()),
                        jwtService.generateRefreshToken(request.getUsername(), request.getPassword())
                )
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse.Response<AuthenticationResponse>> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ApiResponse.success(
                AuthenticationResponse.of(
                        jwtService.generateAccessToken("", ""),
                        jwtService.generateRefreshToken("", "")
                )
        );
    }
}
