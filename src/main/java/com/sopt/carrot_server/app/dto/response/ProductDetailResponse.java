package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;

@Builder
public record ProductDetailResponse(
        Long product_id,
        String product_image,
        String title,
        String category,
        String content,
        String price,
        int view
) {
    public static ProductDetailResponse of(
            final Long product_id,
            final String product_image,
            final String title,
            final String category,
            final String content,
            final String price,
            final int view
    ) {
        return ProductDetailResponse.builder()
                .product_id(product_id)
                .product_image(product_image)
                .title(title)
                .category(category)
                .content(content)
                .price(price)
                .view(view)
                .build();
    }
}