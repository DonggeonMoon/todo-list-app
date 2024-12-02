package com.dgmoonlabs.todolistapp.member.application.service;

import com.dgmoonlabs.todolistapp.member.application.port.in.DeleteMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.out.DeleteMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteMemberService implements DeleteMemberUseCase {
    private final DeleteMemberPort deleteMemberPort;

    @Override
    public void deleteMember(final Long memberId) {
        deleteMemberPort.deleteMember(memberId);
    }
}
