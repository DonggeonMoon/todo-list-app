package com.dgmoonlabs.todolistapp.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

public interface ModifySchedulePort {
    void modifySchedule(final Schedule schedule);
}
