package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface AddScheduleUseCase {
    boolean addSchedule(final Schedule schedule);
}
