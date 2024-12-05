package com.dgmoonlabs.todolistapp.common.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ApiResponse {
    public static <T> ResponseEntity<Response<T>> success(final T data) {
        return ResponseEntity.status(ResponseCode.OK.getStatusCode())
                .body(new Response<>(ResponseCode.OK.getMessage(), data));
    }

    public static ResponseEntity<Response<URI>> createSuccess(URI uri) {
        return ResponseEntity.status(ResponseCode.CREATE_SUCCESS.getStatusCode())
                .body(new Response<>(ResponseCode.UPDATE_SUCCESS.getMessage(), uri));
    }

    public static ResponseEntity<Response<Void>> updateSuccess() {
        return ResponseEntity.status(ResponseCode.UPDATE_SUCCESS.getStatusCode())
                .body(new Response<>(ResponseCode.UPDATE_SUCCESS.getMessage(), null));
    }

    public static ResponseEntity<Response<Void>> deleteSuccess() {
        return ResponseEntity.status(ResponseCode.DELETE_SUCCESS.getStatusCode())
                .body(new Response<>(ResponseCode.DELETE_SUCCESS.getMessage(), null));
    }

    public static ResponseEntity<Response<Void>> fail(final ResponseCode responseCode) {
        return ResponseEntity.status(responseCode.getStatusCode())
                .body(new Response<>(responseCode.getMessage(), null));
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @Getter
    public static class Response<T> {
        private String message;
        private T data;
    }
}
