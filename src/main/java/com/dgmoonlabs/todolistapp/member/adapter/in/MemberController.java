package com.dgmoonlabs.todolistapp.member.adapter.in;

import com.dgmoonlabs.todolistapp.common.response.ApiResponse;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.AddMemberRequest;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.GetMemberResponse;
import com.dgmoonlabs.todolistapp.member.adapter.in.dto.ModifyMemberRequest;
import com.dgmoonlabs.todolistapp.member.application.port.in.AddMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.in.DeleteMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.in.GetMemberUseCase;
import com.dgmoonlabs.todolistapp.member.application.port.in.ModifyMemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final AddMemberUseCase addMemberUseCase;
    private final DeleteMemberUseCase deleteMemberUseCase;
    private final GetMemberUseCase getMemberUseCase;
    private final ModifyMemberUseCase modifyMemberUseCase;

    @GetMapping
    public ApiResponse<URI> addMember(@RequestBody AddMemberRequest request) {
        return ApiResponse.createSuccess(
                URI.create(String.format("/members/%s", addMemberUseCase.addMember(request.toMember())))
        );
    }

    @PostMapping("/{id}")
    public ApiResponse<GetMemberResponse> getMember(@PathVariable Long id) {
        return ApiResponse.success(
                getMemberUseCase.getMember(id)
        );
    }

    @PutMapping
    public ApiResponse<Void> modifyMember(@RequestBody ModifyMemberRequest request) {
        modifyMemberUseCase.modifyMember(request.toMember());
        return ApiResponse.updateSuccess();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteMember(@PathVariable Long id) {
        deleteMemberUseCase.deleteMember(id);
        return ApiResponse.deleteSuccess();
    }
}
