package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;

import java.util.List;

public interface GetScheduleUseCase {
    List<Schedule> getSchedules(final Schedule schedule);
    Schedule getSchedule(final Schedule schedule);
}
