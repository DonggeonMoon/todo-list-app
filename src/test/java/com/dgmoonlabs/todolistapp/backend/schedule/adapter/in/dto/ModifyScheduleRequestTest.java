package com.dgmoonlabs.todolistapp.backend.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import com.dgmoonlabs.todolistapp.backend.schedule.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ModifyScheduleRequestTest extends UnitTestStub {

    @Test
    void toSchedule() {
        ModifyScheduleRequest request = new ModifyScheduleRequest(ID, NAME, DESCRIPTION, DATE, START_TIME, END_TIME);
        Schedule schedule = Schedule.withId(ID, NAME, DESCRIPTION, DATE, START_TIME, END_TIME);

        assertThat(request.toSchedule()).isEqualTo(schedule);
    }
}