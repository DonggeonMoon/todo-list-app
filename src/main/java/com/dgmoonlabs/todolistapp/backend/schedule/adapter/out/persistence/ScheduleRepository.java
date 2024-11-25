package com.dgmoonlabs.todolistapp.backend.schedule.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleJpaEntity, Long> {
    List<ScheduleJpaEntity> findByDate(LocalDate date);
}
