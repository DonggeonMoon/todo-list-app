package com.dgmoonlabs.todolistapp.member.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.common.model.BaseEntity;
import com.dgmoonlabs.todolistapp.schedule.adapter.out.persistence.ScheduleJpaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MemberJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String memberName;
    private String email;
    private int loginAttempts;
    private boolean isLocked;
    private LocalDateTime lockedAt;
    private LocalDateTime lastLoggedInAt;
    private String lastLoggedInIpAddress;
    private String loginFailedIpAddress;
    private LocalDateTime lastPasswordChangedAt;
    @OneToMany(mappedBy = "member")
    private List<ScheduleJpaEntity> schedules;
    @OneToMany(mappedBy = "member")
    private Set<AuthorityJpaEntity> authorities;

    public static MemberJpaEntity of(
            String username,
            String password,
            String memberName,
            String email,
            int loginAttempts,
            boolean isLocked,
            LocalDateTime lockedAt,
            LocalDateTime lastLoggedInAt,
            String lastLoggedInIpAddress,
            String loginFailedIpAddress,
            LocalDateTime lastPasswordChangedAt
    ) {
        return MemberJpaEntity.builder()
                .username(username)
                .password(password)
                .memberName(memberName)
                .email(email)
                .loginAttempts(loginAttempts)
                .isLocked(isLocked)
                .lockedAt(lockedAt)
                .lastLoggedInAt(lastLoggedInAt)
                .lastLoggedInIpAddress(lastLoggedInIpAddress)
                .loginFailedIpAddress(loginFailedIpAddress)
                .lastPasswordChangedAt(lastPasswordChangedAt)
                .build();
    }

    public void update(
            String username,
            String password,
            String memberName,
            String email
    ) {
        this.username = username;
        this.password = password;
        this.memberName = memberName;
        this.email = email;
    }
}
