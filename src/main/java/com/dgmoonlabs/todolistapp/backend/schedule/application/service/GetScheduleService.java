package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.GetScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetScheduleService implements GetScheduleUseCase {
    @Override
    public List<Schedule> getSchedules(final Schedule schedule) {
        return List.of();
    }

    @Override
    public Schedule getSchedule(final Schedule schedule) {
        return null;
    }
}
