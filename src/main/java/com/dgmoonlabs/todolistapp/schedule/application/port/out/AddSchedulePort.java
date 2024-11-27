package com.dgmoonlabs.todolistapp.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

public interface AddSchedulePort {
    Long addSchedule(final Schedule schedule);
}
