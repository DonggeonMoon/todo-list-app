package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.DeleteScheduleUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleService implements DeleteScheduleUseCase {
    @Override
    public boolean deleteSchedule(final Long id) {
        return true;
    }
}
