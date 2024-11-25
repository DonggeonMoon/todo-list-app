package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.adapter.in.dto.GetScheduleResponses;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface GetScheduleUseCase {
    GetScheduleResponses getSchedules();
    GetScheduleResponses getSchedules(final Schedule schedule);
}
