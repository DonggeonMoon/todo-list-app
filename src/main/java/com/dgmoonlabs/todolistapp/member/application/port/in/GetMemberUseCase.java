package com.dgmoonlabs.todolistapp.member.application.port.in;

import com.dgmoonlabs.todolistapp.member.adapter.in.dto.GetMemberResponse;

public interface GetMemberUseCase {
    GetMemberResponse getMember(final Long id);
}
