package com.sopt.carrot_server.global.common.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessCode {

    // Users
    SUCCESS_GET_USER_DETAIL(HttpStatus.OK),
    SUCCESS_GET_USER_SELLING_PRODUCTS(HttpStatus.OK),

    // Product
    SUCCESS_SEARCH_PRODUCTS(HttpStatus.OK),
    SUCCESS_GET_PRODUCT_DETAIL(HttpStatus.OK),
    SUCCESS_GET_PRODUCT_CATEGORIES(HttpStatus.OK),
    SUCCESS_GET_PRODUCTS_BY_CATEGORIES(HttpStatus.OK);

    private final HttpStatus httpStatus;


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
