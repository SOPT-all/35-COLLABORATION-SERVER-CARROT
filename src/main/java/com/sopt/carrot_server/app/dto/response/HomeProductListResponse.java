package com.sopt.carrot_server.app.dto.response;

import com.sopt.carrot_server.app.domain.Product;

import java.util.List;

public record HomeProductListResponse(
        List<HomeProductDetailResponse> products
) {
    public static HomeProductListResponse of(List<HomeProductDetailResponse> products) {

        return new HomeProductListResponse(products);
    }
}
