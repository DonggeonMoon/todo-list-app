package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface AddScheduleUseCase {
    Long addSchedule(final Schedule schedule);
}
