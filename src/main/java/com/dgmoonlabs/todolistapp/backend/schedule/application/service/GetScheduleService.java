package com.dgmoonlabs.todolistapp.backend.schedule.application.service;

import com.dgmoonlabs.todolistapp.backend.common.annotation.UseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.adapter.in.dto.GetScheduleResponses;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.GetScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.GetSchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class GetScheduleService implements GetScheduleUseCase {
    private final GetSchedulePort getSchedulePort;

    @Transactional(readOnly = true)
    @Override
    public GetScheduleResponses getSchedules() {
        return GetScheduleResponses.from(getSchedulePort.getSchedules());
    }

    @Transactional(readOnly = true)
    @Override
    public GetScheduleResponses getSchedules(final Schedule schedule) {
        return GetScheduleResponses.from(getSchedulePort.getSchedules(schedule));
    }
}
