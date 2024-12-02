package com.dgmoonlabs.todolistapp.member.application.service;

import com.dgmoonlabs.todolistapp.member.application.port.in.AddMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.out.AddMemberPort;
import com.dgmoonlabs.todolistapp.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMemberService implements AddMemberUseCase {
    private final AddMemberPort addMemberPort;


    @Override
    public Long addMember(final Member member) {
        return addMemberPort.addMember(member);
    }
}
