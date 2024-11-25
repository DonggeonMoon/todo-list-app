package com.dgmoonlabs.todolistapp.backend.schedule.adapter.in.dto;

import com.dgmoonlabs.todolistapp.backend.schedule.domain.Schedule;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class GetScheduleResponses {
    List<GetScheduleResponse> schedules;

    public static GetScheduleResponses from(final List<Schedule> schedules) {
        return GetScheduleResponses.builder()
                .schedules(
                        schedules.stream()
                                .map(GetScheduleResponse::from)
                                .toList()
                )
                .build();
    }

    @Builder(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
    public static class GetScheduleResponse {
        private Long id;
        private String name;
        private String description;
        private LocalDate date;
        private LocalTime startTime;
        private LocalTime endTime;

        public static GetScheduleResponse from(final Schedule schedule) {
            return GetScheduleResponse.builder()
                    .id(schedule.id())
                    .name(schedule.name())
                    .description(schedule.description())
                    .date(schedule.date())
                    .startTime(schedule.startTime())
                    .endTime(schedule.endTime())
                    .build();
        }
    }
}
