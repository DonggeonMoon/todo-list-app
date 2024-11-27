package com.dgmoonlabs.todolistapp.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.schedule.adapter.in.dto.GetScheduleResponses;
import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

public interface GetScheduleUseCase {
    GetScheduleResponses getSchedules();
    GetScheduleResponses getSchedules(final Schedule schedule);
}
