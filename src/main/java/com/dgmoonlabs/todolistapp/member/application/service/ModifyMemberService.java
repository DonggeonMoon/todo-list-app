package com.dgmoonlabs.todolistapp.member.application.service;

import com.dgmoonlabs.todolistapp.member.application.port.in.ModifyMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.out.ModifyMemberPort;
import com.dgmoonlabs.todolistapp.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModifyMemberService implements ModifyMemberUseCase {
    private final ModifyMemberPort modifyMemberPort;

    @Override
    public void modifyMember(final Member member) {
        modifyMemberPort.modifyMember(member);
    }
}
