package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.ModifyScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import org.springframework.stereotype.Service;

@Service
public class ModifyScheduleService implements ModifyScheduleUseCase {
    @Override
    public boolean modifySchedule(final Schedule schedule) {
        return true;
    }
}
