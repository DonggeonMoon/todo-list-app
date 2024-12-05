package com.dgmoonlabs.todolistapp.common.exception;

import com.dgmoonlabs.todolistapp.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.dgmoonlabs.todolistapp.common.response.ResponseCode.DATA_NOT_FOUND;
import static com.dgmoonlabs.todolistapp.common.response.ResponseCode.INVALID_TIME;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponse.Response<Void>> handleInvalidTimeException() {
        log.error("[GlobalExceptionHandler] - Invalid time");
        return ApiResponse.fail(INVALID_TIME);
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiResponse.Response<Void>> handleDataNotFoundException() {
        log.error("[GlobalExceptionHandler] - Data not found");
        return ApiResponse.fail(DATA_NOT_FOUND);
    }
}
