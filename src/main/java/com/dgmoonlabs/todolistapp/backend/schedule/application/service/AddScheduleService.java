package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.AddScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.AddSchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class AddScheduleService implements AddScheduleUseCase {
    private final AddSchedulePort addSchedulePort;

    @Transactional
    @Override
    public Long addSchedule(final Schedule schedule) {
        return addSchedulePort.addSchedule(schedule);
    }
}
