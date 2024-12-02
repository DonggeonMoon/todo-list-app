package com.dgmoonlabs.todolistapp.member.domain;


public record Member(
        Long id,
        String username,
        String password,
        String memberName,
        String email,
        MemberSecurity memberSecurity
) {
    public static Member withoutId(
            String username,
            String password,
            String memberName,
            String email,
            MemberSecurity memberSecurity
    ) {
        return new Member(
                null,
                username,
                password,
                memberName,
                email,
                memberSecurity
        );
    }

    public static Member withId(
            Long id,
            String username,
            String password,
            String memberName,
            String email,
            MemberSecurity memberSecurity) {
        return new Member(
                id,
                username,
                password,
                memberName,
                email,
                memberSecurity
        );
    }
}