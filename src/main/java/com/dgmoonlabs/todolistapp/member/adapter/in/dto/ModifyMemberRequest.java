package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ModifyMemberRequest {
    private Long id;
    private String username;
    private String password;
    private String memberName;
    private String email;
    private MemberSecurity memberSecurity;

    public Member toMember() {
        return Member.withId(
                id,
                username,
                password,
                memberName,
                email,
                memberSecurity
        );
    }
}
