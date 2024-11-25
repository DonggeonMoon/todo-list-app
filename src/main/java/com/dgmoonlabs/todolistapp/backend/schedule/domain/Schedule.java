package com.dgmoonlabs.todolistapp.backend.schedule.domain;

import com.dgmoonlabs.todolistapp.backend.common.exception.InvalidTimeException;

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

        if (startTime == null) {
            return new Schedule(null, name, description, date, null, null);
        }

        validateTime(startTime, endTime);


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

        if (startTime == null) {
            return new Schedule(id, name, description, date, null, null);
        }

        validateTime(startTime, endTime);

        return new Schedule(id, name, description, date, startTime, endTime);
    }

    private static void validateTime(LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new InvalidTimeException();
        }
    }
}
