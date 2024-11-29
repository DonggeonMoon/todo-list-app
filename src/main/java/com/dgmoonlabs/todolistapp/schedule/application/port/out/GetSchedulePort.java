package com.dgmoonlabs.todolistapp.schedule.application.port.out;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

import java.util.List;

public interface GetSchedulePort {
    List<Schedule> getSchedules();

    List<Schedule> getSchedules(final Schedule schedule);

    Schedule getSchedule(final Long id);
}
