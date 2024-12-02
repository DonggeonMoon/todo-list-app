package com.dgmoonlabs.todolistapp.member.application.port.out;

import com.dgmoonlabs.todolistapp.member.domain.Member;

public interface ModifyMemberPort {
    void modifyMember(final Member member);
}
