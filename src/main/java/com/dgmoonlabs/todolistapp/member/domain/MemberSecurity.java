package com.dgmoonlabs.todolistapp.member.domain;


import java.time.LocalDateTime;

public record MemberSecurity(
        Long id,
        int loginAttempts,
        boolean isLocked,
        LocalDateTime lockedAt,
        LocalDateTime lastLoggedInAt,
        String lastLoggedInIpAddress,
        String loginFailedIpAddress,
        LocalDateTime lastPasswordChangedAt
) {
    public static MemberSecurity create() {
        return new MemberSecurity(
                null,
                0,
                false,
                null,
                null,
                null,
                null,
                null
        );
    }
}