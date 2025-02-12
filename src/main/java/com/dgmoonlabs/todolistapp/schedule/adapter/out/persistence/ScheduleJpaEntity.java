package com.dgmoonlabs.todolistapp.schedule.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.common.model.BaseEntity;
import com.dgmoonlabs.todolistapp.member.adapter.out.persistence.MemberJpaEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ScheduleJpaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberJpaEntity member;

    public static ScheduleJpaEntity of(String name, String description, LocalDate date, LocalTime startTime, LocalTime endTime) {
        return new ScheduleJpaEntity(null, name, description, date, startTime, endTime, null);
    }

    public void update(String name, String description, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
