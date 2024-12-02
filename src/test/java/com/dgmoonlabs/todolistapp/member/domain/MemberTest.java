package com.dgmoonlabs.todolistapp.member.domain;

import com.dgmoonlabs.todolistapp.member.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest extends UnitTestStub {
    @Test
    void withoutId() {
        Member member = Member.withoutId(USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MEMBER_SECURITY);

        assertThat(member.id()).isNull();
        assertThat(member.username()).isEqualTo(USERNAME);
        assertThat(member.password()).isEqualTo(PASSWORD);
        assertThat(member.memberName()).isEqualTo(MEMBER_NAME);
        assertThat(member.email()).isEqualTo(EMAIL);
        assertThat(member.memberSecurity()).isEqualTo(MEMBER_SECURITY);
    }

    @Test
    void withId() {
        Member member = Member.withId(ID, USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MEMBER_SECURITY);

        assertThat(member.id()).isEqualTo(ID);
        assertThat(member.username()).isEqualTo(USERNAME);
        assertThat(member.password()).isEqualTo(PASSWORD);
        assertThat(member.memberName()).isEqualTo(MEMBER_NAME);
        assertThat(member.email()).isEqualTo(EMAIL);
        assertThat(member.memberSecurity()).isEqualTo(MEMBER_SECURITY);
    }
}