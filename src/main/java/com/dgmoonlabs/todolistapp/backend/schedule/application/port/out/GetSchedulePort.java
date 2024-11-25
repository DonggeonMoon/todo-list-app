package com.dgmoonlabs.todolistapp.backend.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

import java.util.List;

public interface GetSchedulePort {
    List<Schedule> getSchedules();

    List<Schedule> getSchedules(final Schedule schedule);
}
