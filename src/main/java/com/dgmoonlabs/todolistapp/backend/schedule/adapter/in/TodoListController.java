package com.dgmoonlabs.todolistapp.backend.schedule.adapter.in;

import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.AddScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.DeleteScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.GetScheduleUseCase;
import com.dgmoonlabs.todolistapp.backend.schedule.application.port.in.ModifyScheduleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class TodoListController {
    private final AddScheduleUseCase addScheduleUseCase;
    private final DeleteScheduleUseCase deleteScheduleUseCase;
    private final GetScheduleUseCase getScheduleUseCase;
    private final ModifyScheduleUseCase modifyScheduleUseCase;

    @GetMapping
    public ResponseEntity<List<GetScheduleResponse>> getSchedules(GetSchedulesRequest request) {
        getScheduleUseCase.getSchedules(request.toSchedule());
        return null;
    }

    @GetMapping
    public ResponseEntity<GetScheduleResponse> getSchedule(GetScheduleRequest request) {
        getScheduleUseCase.getSchedule(request.toSchedule());
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> addSchedule(AddScheduleRequest request) {
        addScheduleUseCase.addSchedule(request.toSchedule());
        return ResponseEntity.created(
                URI.create("/api/schedules")
        ).build();
    }

    @PutMapping
    public ResponseEntity<Void> modifySchedule(ModifyScheduleRequest request) {
        modifyScheduleUseCase.modifySchedule(request.toSchedule());
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> deleteSchedule(Long id) {
        deleteScheduleUseCase.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}


