package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import com.dgmoonlabs.todolistapp.member.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GetMemberResponseTest extends UnitTestStub {

    @Test
    void from() {
        Member member = Member.withoutId(USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MemberSecurity.create());
        GetMemberResponse response = GetMemberResponse.from(member);

        assertThat(member.id()).isEqualTo(response.getId());
        assertThat(member.username()).isEqualTo(response.getUsername());
        assertThat(member.password()).isEqualTo(response.getPassword());
        assertThat(member.memberName()).isEqualTo(response.getMemberName());
        assertThat(member.email()).isEqualTo(response.getEmail());
    }
}