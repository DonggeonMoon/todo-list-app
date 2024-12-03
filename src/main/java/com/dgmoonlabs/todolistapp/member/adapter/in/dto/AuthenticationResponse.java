package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class AuthenticationResponse {
    private String accessToken;
    private String refreshToken;

    public static AuthenticationResponse of(String accessToken, String refreshToken) {
        return new AuthenticationResponse(accessToken, refreshToken);
    }
}
