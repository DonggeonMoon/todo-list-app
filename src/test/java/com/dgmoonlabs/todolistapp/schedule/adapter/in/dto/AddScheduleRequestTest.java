package com.dgmoonlabs.todolistapp.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;
import com.dgmoonlabs.todolistapp.schedule.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddScheduleRequestTest extends UnitTestStub {
    @Test
    void toSchedule() {
        AddScheduleRequest addScheduleRequest = new AddScheduleRequest(NAME, DESCRIPTION, DATE, START_TIME, END_TIME);
        Schedule schedule = Schedule.withoutId(NAME, DESCRIPTION, DATE, START_TIME, END_TIME);

        assertThat(addScheduleRequest.toSchedule()).isEqualTo(schedule);
    }
}