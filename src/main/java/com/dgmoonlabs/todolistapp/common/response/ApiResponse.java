package com.dgmoonlabs.todolistapp.common.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class ApiResponse<T> {
    private ApiHeader header;
    private T data;

    public static <T> ApiResponse<T> success(final T data) {
        return new ApiResponse<>(new ApiHeader(ResponseCode.OK.getStatusCode(), ResponseCode.OK.getMessage()), data);
    }

    public static ApiResponse<URI> createSuccess(URI uri) {
        return new ApiResponse<>(new ApiHeader(ResponseCode.CREATE_SUCCESS.getStatusCode(), ResponseCode.UPDATE_SUCCESS.getMessage()), uri);
    }

    public static ApiResponse<Void> updateSuccess() {
        return new ApiResponse<>(new ApiHeader(ResponseCode.UPDATE_SUCCESS.getStatusCode(), ResponseCode.UPDATE_SUCCESS.getMessage()), null);
    }

    public static ApiResponse<Void> deleteSuccess() {
        return new ApiResponse<>(new ApiHeader(ResponseCode.DELETE_SUCCESS.getStatusCode(), ResponseCode.DELETE_SUCCESS.getMessage()), null);
    }

    public static ApiResponse<Void> fail(final ResponseCode responseCode) {
        return new ApiResponse<>(new ApiHeader(responseCode.getStatusCode(), responseCode.getMessage()), null);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @Getter
    public static class ApiHeader {
        private int code;
        private String message;
    }
}
