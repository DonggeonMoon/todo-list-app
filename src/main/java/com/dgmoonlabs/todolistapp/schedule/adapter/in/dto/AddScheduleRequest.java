package com.dgmoonlabs.todolistapp.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class AddScheduleRequest {
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Schedule toSchedule() {
        return Schedule.withoutId(name, description, date, startTime, endTime);
    }
}
