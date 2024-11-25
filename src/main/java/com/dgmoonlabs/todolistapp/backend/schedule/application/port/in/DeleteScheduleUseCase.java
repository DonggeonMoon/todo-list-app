package com.dgmoonlabs.todolistapp.backend.schedule.application.port.in;

public interface DeleteScheduleUseCase {
    boolean deleteSchedule(final Long id);
}
