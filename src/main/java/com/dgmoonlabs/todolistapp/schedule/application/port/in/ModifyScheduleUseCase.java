package com.dgmoonlabs.todolistapp.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

public interface ModifyScheduleUseCase {
    void modifySchedule(final Schedule schedule);
}
