package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.AddScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import org.springframework.stereotype.Service;

@Service
public class AddScheduleService implements AddScheduleUseCase {
    @Override
    public boolean addSchedule(final Schedule schedule) {
        return true;
    }
}
