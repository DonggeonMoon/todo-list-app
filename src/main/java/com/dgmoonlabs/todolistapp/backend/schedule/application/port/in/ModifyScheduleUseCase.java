package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface ModifyScheduleUseCase {
    void modifySchedule(final Schedule schedule);
}
