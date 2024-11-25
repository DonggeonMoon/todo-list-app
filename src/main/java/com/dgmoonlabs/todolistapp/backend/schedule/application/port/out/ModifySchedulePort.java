package com.dgmoonlabs.todolistapp.backend.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface ModifySchedulePort {
    void modifySchedule(final Schedule schedule);
}
