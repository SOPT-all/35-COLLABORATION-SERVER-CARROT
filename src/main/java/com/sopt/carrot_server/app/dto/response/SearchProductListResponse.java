package com.sopt.carrot_server.app.dto.response;

import java.util.List;

public record SearchProductListResponse(
        List<SearchProductDetailResponse> products,
        List<SearchProductDetailResponse> similar_products

) {
    public static SearchProductListResponse of(
            final List<SearchProductDetailResponse> products,
            final List<SearchProductDetailResponse> similar_products
    ) {
        return new SearchProductListResponse(products, similar_products);
    }
}
