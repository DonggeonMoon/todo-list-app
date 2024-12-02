package com.dgmoonlabs.todolistapp.member.application.port.in;

import com.dgmoonlabs.todolistapp.member.domain.Member;

public interface ModifyMemberUseCase {
    void modifyMember(final Member member);
}
