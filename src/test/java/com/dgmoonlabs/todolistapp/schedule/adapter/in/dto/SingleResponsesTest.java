package com.dgmoonlabs.todolistapp.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.schedule.stub.UnitTestStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleResponsesTest extends UnitTestStub {
    @Test
    void from() {
        GetScheduleResponses responses = GetScheduleResponses.from(List.of(SCHEDULE, SCHEDULE));

        assertThat(responses.schedules)
                .isEqualTo(
                        List.of(
                                GetScheduleResponses.SingleResponse.from(SCHEDULE),
                                GetScheduleResponses.SingleResponse.from(SCHEDULE)
                        )
                );
    }
}