package com.dgmoonlabs.todolistapp.member.application.service;

import com.dgmoonlabs.todolistapp.member.adapter.in.dto.GetMemberResponse;
import com.dgmoonlabs.todolistapp.member.application.port.in.GetMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.out.GetMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMemberService implements GetMemberUseCase {
    private final GetMemberPort getMemberPort;

    @Override
    public GetMemberResponse getMember(final Long id) {
        return GetMemberResponse.from(
                getMemberPort.getMember(id)
        );
    }
}
