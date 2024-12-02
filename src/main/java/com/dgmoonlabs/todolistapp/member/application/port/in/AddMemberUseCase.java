package com.dgmoonlabs.todolistapp.member.application.port.in;

import com.dgmoonlabs.todolistapp.member.domain.Member;

public interface AddMemberUseCase {
    Long addMember(final Member request);
}
