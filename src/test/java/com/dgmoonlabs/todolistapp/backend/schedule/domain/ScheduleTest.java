package com.dgmoonlabs.todolistapp.backend.schedule.domain;

import com.dgmoonlabs.todolistapp.backend.common.exception.InvalidTimeException;
import com.dgmoonlabs.todolistapp.backend.schedule.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScheduleTest extends UnitTestStub {
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

    @Test
    void validateTime() {
        assertThatThrownBy(() -> Schedule.withId(ID, NAME, DESCRIPTION, DATE, END_TIME, START_TIME))
                .isInstanceOf(InvalidTimeException.class);

        assertThatThrownBy(() -> Schedule.withoutId(NAME, DESCRIPTION, DATE, END_TIME, START_TIME))
                .isInstanceOf(InvalidTimeException.class);
    }
}