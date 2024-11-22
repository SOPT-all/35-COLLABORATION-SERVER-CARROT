package com.sopt.carrot_server.global.common.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    // Users
    SUCCESS_GET_USER_DETAIL(HttpStatus.OK),

    // Search
    SUCCESS_SEARCH_PRODUCTS(HttpStatus.OK);

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
