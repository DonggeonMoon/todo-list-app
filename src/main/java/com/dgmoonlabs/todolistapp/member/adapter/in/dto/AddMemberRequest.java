package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class AddMemberRequest {
    private String username;
    private String password;
    private String memberName;
    private String email;

    public Member toMember() {
        return Member.withoutId(
                username,
                password,
                memberName,
                email,
                MemberSecurity.create()
        );
    }
}
