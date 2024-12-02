package com.dgmoonlabs.todolistapp.member.adapter.in.dto;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import lombok.*;

@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class GetMemberResponse {
    private Long id;
    private String username;
    private String password;
    private String memberName;
    private String email;

    public static GetMemberResponse from(Member member) {
        return GetMemberResponse.builder()
                .id(member.id())
                .username(member.username())
                .password(member.password())
                .memberName(member.memberName())
                .email(member.email())
                .build();
    }
}
