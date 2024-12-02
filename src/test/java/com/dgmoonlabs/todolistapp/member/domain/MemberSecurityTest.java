package com.dgmoonlabs.todolistapp.member.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberSecurityTest {

    @Test
    void create() {
        MemberSecurity memberSecurity = MemberSecurity.create();
        assertThat(memberSecurity.id()).isNull();
        assertThat(memberSecurity.loginAttempts()).isZero();
        assertThat(memberSecurity.isLocked()).isFalse();
        assertThat(memberSecurity.lockedAt()).isNull();
        assertThat(memberSecurity.lastLoggedInAt()).isNull();
        assertThat(memberSecurity.lastLoggedInIpAddress()).isNull();
        assertThat(memberSecurity.loginFailedIpAddress()).isNull();
        assertThat(memberSecurity.lastPasswordChangedAt()).isNull();
    }
}