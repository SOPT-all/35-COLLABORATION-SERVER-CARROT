package com.sopt.carrot_server.global.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.sopt.carrot_server.global.common.code.SuccessCode;

@JsonPropertyOrder({"status", "result"})
public record SuccessResponse<T>(
        int status,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T result
) {
    public static <T> SuccessResponse of(SuccessCode successCode){
        return new SuccessResponse(successCode.getHttpStatus().value(), null);
    }

    public static <T> SuccessResponse of(SuccessCode successCode, T result){
        return new SuccessResponse(successCode.getHttpStatus().value(), result);
    }
}
