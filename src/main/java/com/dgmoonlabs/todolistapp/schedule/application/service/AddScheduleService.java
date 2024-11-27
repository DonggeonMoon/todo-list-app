package com.dgmoonlabs.todolistapp.schedule.application.service;

import com.dgmoonlabs.todolistapp.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.AddScheduleUseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.out.AddSchedulePort;
import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;
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
