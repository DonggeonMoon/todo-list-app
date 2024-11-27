package com.dgmoonlabs.todolistapp.schedule.adapter.out.persistence;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
class ScheduleMapper {
    ScheduleJpaEntity mapToEntity(Schedule schedule) {
        return ScheduleJpaEntity.of(
                schedule.name(),
                schedule.description(),
                schedule.date(),
                schedule.startTime(),
                schedule.endTime()
        );
    }

    List<Schedule> mapToModel(List<ScheduleJpaEntity> scheduleJpaEntities) {
        return scheduleJpaEntities.stream()
                .map(scheduleJpaEntity -> Schedule.withId(
                                scheduleJpaEntity.getId(),
                                scheduleJpaEntity.getName(),
                                scheduleJpaEntity.getDescription(),
                                scheduleJpaEntity.getDate(),
                                scheduleJpaEntity.getStartTime(),
                                scheduleJpaEntity.getEndTime()
                        )
                ).toList();
    }
}
