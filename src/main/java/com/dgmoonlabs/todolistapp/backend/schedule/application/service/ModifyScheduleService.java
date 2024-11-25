package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.ModifyScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.ModifySchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class ModifyScheduleService implements ModifyScheduleUseCase {
    private final ModifySchedulePort modifySchedulePort;

    @Transactional
    @Override
    public void modifySchedule(final Schedule schedule) {
        modifySchedulePort.modifySchedule(schedule);
    }
}
