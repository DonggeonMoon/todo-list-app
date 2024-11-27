package com.dgmoonlabs.todolistapp.schedule.adapter.in;

import com.dgmoonlabs.todolistapp.common.annotation.WebAdapter;
import com.dgmoonlabs.todolistapp.common.response.ApiResponse;
import com.dgmoonlabs.todolistapp.schedule.adapter.in.dto.AddScheduleRequest;
import com.dgmoonlabs.todolistapp.schedule.adapter.in.dto.GetScheduleResponses;
import com.dgmoonlabs.todolistapp.schedule.adapter.in.dto.GetSchedulesRequest;
import com.dgmoonlabs.todolistapp.schedule.adapter.in.dto.ModifyScheduleRequest;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.AddScheduleUseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.DeleteScheduleUseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.GetScheduleUseCase;
import com.dgmoonlabs.todolistapp.schedule.application.port.in.ModifyScheduleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class TodoListController {
    private final AddScheduleUseCase addScheduleUseCase;
    private final DeleteScheduleUseCase deleteScheduleUseCase;
    private final GetScheduleUseCase getScheduleUseCase;
    private final ModifyScheduleUseCase modifyScheduleUseCase;

    @PostMapping
    public ApiResponse<URI> addSchedule(@RequestBody AddScheduleRequest request) {
        return ApiResponse.success(
                URI.create(String.format("/api/schedules/%s", addScheduleUseCase.addSchedule(request.toSchedule())))
        );
    }

    @GetMapping
    public ApiResponse<GetScheduleResponses> getSchedules(@RequestBody(required = false) GetSchedulesRequest request) {
        return ApiResponse.success(
                request == null
                        ? getScheduleUseCase.getSchedules()
                        : getScheduleUseCase.getSchedules(request.toSchedule())
        );
    }

    @PutMapping
    public ApiResponse<Void> modifySchedule(@RequestBody ModifyScheduleRequest request) {
        modifyScheduleUseCase.modifySchedule(request.toSchedule());
        return ApiResponse.updateSuccess();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteSchedule(@PathVariable Long id) {
        deleteScheduleUseCase.deleteSchedule(id);
        return ApiResponse.deleteSuccess();
    }
}


