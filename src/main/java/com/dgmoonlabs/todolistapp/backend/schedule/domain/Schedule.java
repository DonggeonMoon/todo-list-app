package com.dgmoonlabs.todolistapp.backend.schedule.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public record Schedule(
        Long id,
        String name,
        String description,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime
) {
    public static Schedule withoutId(String name, String description, LocalDate date) {
        return new Schedule(null, name, description, date, null, null);
    }

    public static Schedule withoutId(String name, String description, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (startTime == null && endTime != null) {
            return new Schedule(null, name, description, date, LocalTime.MIN, endTime);
        }

        if (startTime != null && endTime == null) {
            return new Schedule(null, name, description, date, startTime, LocalTime.MAX);
        }

        return new Schedule(null, name, description, date, startTime, endTime);
    }

    public static Schedule withId(Long id, String name, String description, LocalDate date) {
        return new Schedule(id, name, description, date, null, null);
    }

    public static Schedule withId(Long id, String name, String description, LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (startTime == null && endTime != null) {
            return new Schedule(id, name, description, date, LocalTime.MIN, endTime);
        }

        if (startTime != null && endTime == null) {
            return new Schedule(id, name, description, date, startTime, LocalTime.MAX);
        }

        return new Schedule(id, name, description, date, startTime, endTime);
    }
}
