package com.dgmoonlabs.todolistapp.member.application.port.out;

import com.dgmoonlabs.todolistapp.member.domain.Member;

public interface GetMemberPort {
    Member getMember(final Long id);
}
