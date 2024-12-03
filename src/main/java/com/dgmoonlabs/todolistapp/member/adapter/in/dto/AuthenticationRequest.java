package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class AuthenticationRequest {
    private String username;
    private String password;
}
