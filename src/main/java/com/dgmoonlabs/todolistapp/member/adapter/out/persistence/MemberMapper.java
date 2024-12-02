package com.dgmoonlabs.todolistapp.member.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.member.domain.Member;
import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
class MemberMapper {
    MemberJpaEntity mapToEntity(Member member) {
        return MemberJpaEntity.of(
                member.username(),
                member.password(),
                member.memberName(),
                member.email(),
                member.memberSecurity().loginAttempts(),
                member.memberSecurity().isLocked(),
                member.memberSecurity().lockedAt(),
                member.memberSecurity().lastLoggedInAt(),
                member.memberSecurity().lastLoggedInIpAddress(),
                member.memberSecurity().loginFailedIpAddress(),
                member.memberSecurity().lastPasswordChangedAt()
        );
    }

    Member mapToMember(MemberJpaEntity entity) {
        return Member.withoutId(
                entity.getUsername(),
                entity.getPassword(),
                entity.getMemberName(),
                entity.getEmail(),
                new MemberSecurity(
                        entity.getId(),
                        entity.getLoginAttempts(),
                        entity.isLocked(),
                        entity.getLockedAt(),
                        entity.getLastLoggedInAt(),
                        entity.getLastLoggedInIpAddress(),
                        entity.getLoginFailedIpAddress(),
                        entity.getLastPasswordChangedAt()
                )
        );
    }
}
