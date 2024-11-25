package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.DeleteScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.DeleteSchedulePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class DeleteScheduleService implements DeleteScheduleUseCase {
    private final DeleteSchedulePort deleteSchedulePort;

    @Transactional
    @Override
    public void deleteSchedule(final Long id) {
        deleteSchedulePort.deleteSchedule(id);
    }
}
