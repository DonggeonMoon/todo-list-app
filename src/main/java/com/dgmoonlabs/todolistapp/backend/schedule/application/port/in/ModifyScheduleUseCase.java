package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface ModifyScheduleUseCase {
    boolean modifySchedule(final Schedule schedule);
}
