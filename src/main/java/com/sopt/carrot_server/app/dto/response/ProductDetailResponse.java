package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;

@Builder
public record ProductDetailResponse(
        Long productId,
        String productImage,
        String title,
        String category,
        String content,
        String price,
        int view
) {
    public static ProductDetailResponse of(
            final Long productId,
            final String productImage,
            final String title,
            final String category,
            final String content,
            final String price,
            final int view
    ) {
        return ProductDetailResponse.builder()
                .productId(productId)
                .productImage(productImage)
                .title(title)
                .category(category)
                .content(content)
                .price(price)
                .view(view)
                .build();
    }
}
