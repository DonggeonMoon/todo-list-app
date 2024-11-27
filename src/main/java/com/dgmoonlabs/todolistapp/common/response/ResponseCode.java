package com.dgmoonlabs.todolistapp.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ResponseCode {
    OK(HttpStatus.OK, "성공"),
    UPDATE_SUCCESS(HttpStatus.NO_CONTENT, "수정 성공"),
    DELETE_SUCCESS(HttpStatus.NO_CONTENT, "삭제 성공"),
    INVALID_TIME(HttpStatus.BAD_REQUEST, "종료 시간이 시작 시간보다 빠릅니다."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;

    public int getStatusCode() {
        return status.value();
    }
}
