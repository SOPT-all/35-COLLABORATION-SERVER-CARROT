package com.sopt.carrot_server.app.dto.response;

import java.util.List;

public record UserSellingProductListResponse(
        List<UserSellingProductDetailResponse> products
) {
    public static UserSellingProductListResponse of(
            final List<UserSellingProductDetailResponse> products
    ) {
        return new UserSellingProductListResponse(products);
    }
}
