package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import com.dgmoonlabs.todolistapp.member.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddMemberRequestTest extends UnitTestStub {

    @Test
    void toMember() {
        AddMemberRequest request = new AddMemberRequest(USERNAME, PASSWORD, MEMBER_NAME, EMAIL);
        Member member = Member.withoutId(USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MemberSecurity.create());

        assertThat(request.toMember()).isEqualTo(member);
    }
}