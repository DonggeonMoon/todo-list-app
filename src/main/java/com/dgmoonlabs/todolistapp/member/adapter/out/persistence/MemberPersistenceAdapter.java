package com.dgmoonlabs.todolistapp.member.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.common.exception.DataNotFoundException;
import com.dgmoonlabs.todolistapp.member.application.port.out.AddMemberPort;
import com.dgmoonlabs.todolistapp.member.application.port.out.DeleteMemberPort;
import com.dgmoonlabs.todolistapp.member.application.port.out.GetMemberPort;
import com.dgmoonlabs.todolistapp.member.application.port.out.ModifyMemberPort;
import com.dgmoonlabs.todolistapp.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements AddMemberPort, DeleteMemberPort, GetMemberPort, ModifyMemberPort {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Long addMember(final Member member) {
        return memberRepository.save(
                memberMapper.mapToEntity(member)
        ).getId();
    }

    @Override
    public Member getMember(final Long id) {
        return memberMapper.mapToMember(
                memberRepository.findById(id).orElseThrow(DataNotFoundException::new)
        );
    }

    @Override
    public void modifyMember(final Member member) {
        memberRepository.findById(member.id())
                .orElseThrow(DataNotFoundException::new)
                .update(
                        member.username(),
                        member.password(),
                        member.memberName(),
                        member.email()
                );
    }

    @Override
    public void deleteMember(final Long id) {
        memberRepository.deleteById(id);
    }
}
