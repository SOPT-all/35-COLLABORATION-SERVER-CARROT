package com.sopt.carrot_server.global.common.code;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum FailureCode {

    INVALID_VALUE(HttpStatus.BAD_REQUEST, "잘못된 값입니다."),
    MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "필수 파라미터가 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다."),

    // User
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 유저를 찾을 수 없습니다."),

    // Product
    INVALID_CATEGORY(HttpStatus.BAD_REQUEST, "올바르지 않은 카테고리 값입니다."),

    // Category
    NOT_EXISTS_CATEGORY(HttpStatus.BAD_REQUEST, "잘못된 카테고리 값입니다.");


    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
