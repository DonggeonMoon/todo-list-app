package com.dgmoonlabs.todolistapp.backend.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

public interface AddSchedulePort {
    Long addSchedule(final Schedule schedule);
}
