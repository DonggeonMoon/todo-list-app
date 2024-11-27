package com.dgmoonlabs.todolistapp.schedule.application.service;

import com.dgmoonlabs.todolistapp.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.ModifyScheduleUseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.out.ModifySchedulePort;
import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;
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
