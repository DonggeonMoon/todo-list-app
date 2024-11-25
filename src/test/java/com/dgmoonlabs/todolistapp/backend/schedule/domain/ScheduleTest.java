package com.dgmoonlabs.todolistapp.backend.schedule.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class ScheduleTest {
    public static final String NAME = "주간 회의";
    public static final String DESCRIPTION = "부서 간 정기 회의 및 주간 점검";
    public static final LocalDate DATE = LocalDate.of(2024, 11, 22);
    public static final LocalTime START_TIME = LocalTime.of(16, 0);
    public static final LocalTime END_TIME = LocalTime.of(17, 0);
    public static final long ID = 1L;

    @Test
    void withoutId() {
        Schedule schedule = Schedule.withoutId(NAME, DESCRIPTION, DATE);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isNull();
        assertThat(schedule.endTime()).isNull();
    }

    @Test
    void withoutIdWithStartTimeAndEndTime() {
        Schedule schedule = Schedule.withoutId(NAME, DESCRIPTION, DATE, START_TIME, END_TIME);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(START_TIME);
        assertThat(schedule.endTime()).isEqualTo(END_TIME);
    }

    @Test
    void withoutIdNullStartTimeAndEndTime() {
        Schedule schedule = Schedule.withoutId(NAME, DESCRIPTION, DATE, null, END_TIME);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(LocalTime.MIN);
        assertThat(schedule.endTime()).isEqualTo(END_TIME);
    }

    @Test
    void withoutIdWithStartTimeAndNullEndTime() {
        Schedule schedule = Schedule.withoutId(NAME, DESCRIPTION, DATE, START_TIME, null);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(START_TIME);
        assertThat(schedule.endTime()).isEqualTo(LocalTime.MAX);
    }

    @Test
    void withId() {
        Schedule schedule = Schedule.withId(ID, NAME, DESCRIPTION, DATE);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isNull();
        assertThat(schedule.endTime()).isNull();
    }

    @Test
    void withIdWithStartTimeAndEndTime() {
        Schedule schedule = Schedule.withId(ID, NAME, DESCRIPTION, DATE, START_TIME, END_TIME);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(START_TIME);
        assertThat(schedule.endTime()).isEqualTo(END_TIME);
    }

    @Test
    void withIdNullStartTimeAndEndTime() {
        Schedule schedule = Schedule.withId(ID, NAME, DESCRIPTION, DATE, null, END_TIME);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(LocalTime.MIN);
        assertThat(schedule.endTime()).isEqualTo(END_TIME);
    }

    @Test
    void withIdWithStartTimeAndNullEndTime() {
        Schedule schedule = Schedule.withId(ID, NAME, DESCRIPTION, DATE, START_TIME, null);

        assertThat(schedule.name()).isEqualTo(NAME);
        assertThat(schedule.description()).isEqualTo(DESCRIPTION);
        assertThat(schedule.date()).isEqualTo(DATE);
        assertThat(schedule.startTime()).isEqualTo(START_TIME);
        assertThat(schedule.endTime()).isEqualTo(LocalTime.MAX);
    }
}