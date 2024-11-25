package com.dgmoonlabs.todolistapp.backend.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.backend.schedule.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetScheduleResponsesTest extends UnitTestStub {


    @Test
    void from() {
        GetScheduleResponses responses = GetScheduleResponses.from(List.of(SCHEDULE, SCHEDULE));

        assertThat(responses.schedules)
                .isEqualTo(
                        List.of(
                                GetScheduleResponses.GetScheduleResponse.from(SCHEDULE),
                                GetScheduleResponses.GetScheduleResponse.from(SCHEDULE)
                        )
                );
    }
}