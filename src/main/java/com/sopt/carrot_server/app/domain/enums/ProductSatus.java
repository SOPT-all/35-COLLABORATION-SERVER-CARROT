package com.sopt.carrot_server.app.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductSatus {
    FOR_SALE("판매중"),
    SOLD_OUT("판매완료");

    private final String value;
}