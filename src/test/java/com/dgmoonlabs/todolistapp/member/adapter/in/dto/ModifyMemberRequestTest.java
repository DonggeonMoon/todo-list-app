package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import com.dgmoonlabs.todolistapp.member.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ModifyMemberRequestTest extends UnitTestStub {

    @Test
    void toMember() {
        ModifyMemberRequest request = new ModifyMemberRequest(ID, USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MEMBER_SECURITY);
        Member member = Member.withId(ID, USERNAME, PASSWORD, MEMBER_NAME, EMAIL, MemberSecurity.create());

        assertThat(request.toMember()).isEqualTo(member);
    }
}