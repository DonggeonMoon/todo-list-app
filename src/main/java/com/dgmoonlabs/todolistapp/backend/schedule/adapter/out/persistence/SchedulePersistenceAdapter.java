package com.dgmoonlabs.todolistapp.backend.schedule.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.backend.common.annotation.PersistenceAdapter;
import com.dgmoonlabs.todolistapp.backend.common.exception.DataNotFoundException;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.AddSchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.DeleteSchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.GetSchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.out.ModifySchedulePort;
import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class SchedulePersistenceAdapter
        implements
        AddSchedulePort,
        DeleteSchedulePort,
        GetSchedulePort,
        ModifySchedulePort {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public Long addSchedule(final Schedule schedule) {
        return scheduleRepository.save(
                scheduleMapper.mapToEntity(schedule)
        ).getId();
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleMapper.mapToModel(scheduleRepository.findAll());
    }

    @Override
    public List<Schedule> getSchedules(final Schedule schedule) {
        return scheduleMapper.mapToModel(scheduleRepository.findByDate(schedule.date()));
    }

    @Override
    public void modifySchedule(final Schedule schedule) {
        scheduleRepository.findById(schedule.id())
                .orElseThrow(DataNotFoundException::new)
                .update(
                        schedule.name(),
                        schedule.description(),
                        schedule.date(),
                        schedule.startTime(),
                        schedule.endTime()
                );
    }

    @Override
    public void deleteSchedule(final Long id) {
        scheduleRepository.deleteById(id);
    }
}
