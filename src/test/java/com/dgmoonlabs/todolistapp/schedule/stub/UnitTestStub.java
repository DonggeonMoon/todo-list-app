package com.dgmoonlabs.todolistapp.schedule.stub;

import com.dgmoonlabs.todolistapp.schedule.domain.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class UnitTestStub {
    public static final String NAME = "주간 회의";
    public static final String DESCRIPTION = "부서 간 정기 회의 및 주간 점검";
    public static final LocalDate DATE = LocalDate.of(2024, 11, 22);
    public static final LocalTime START_TIME = LocalTime.of(16, 0);
    public static final LocalTime END_TIME = LocalTime.of(17, 0);
    public static final long ID = 1L;
    public static final Schedule SCHEDULE = Schedule.withoutId(NAME, DESCRIPTION, DATE, START_TIME, END_TIME);
}
