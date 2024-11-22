package com.sopt.carrot_server.global.common.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    SUCCESS_CREATE_DIARY(HttpStatus.CREATED),
    SUCCESS_UPDATE_DIARY(HttpStatus.OK),
    SUCCESS_DELETE_DIARY(HttpStatus.OK),
    SUCCESS_GET_DIARY_DETAIL(HttpStatus.OK),
    SUCCESS_GET_PRODUCT_DETAIL(HttpStatus.OK);
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
