package com.dgmoonlabs.todolistapp.backend.schedule.adapter.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ModifyScheduleRequest {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule toSchedule() {
        return Schedule.withId(id, name, description, date, startTime, endTime);
    }
}
