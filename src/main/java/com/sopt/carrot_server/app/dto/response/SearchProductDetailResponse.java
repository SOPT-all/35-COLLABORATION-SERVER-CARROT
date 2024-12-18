package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record SearchProductDetailResponse(
        Long id,
        Long user_id,
        String product_image,
        String title,
        String address,
        String price
) {
    public static SearchProductDetailResponse of(
            final Long id,
            final Long user_id,
            final String product_image,
            final String title,
            final String address,
            final String price
    ) {
        return SearchProductDetailResponse.builder()
                .id(id)
                .user_id(user_id)
                .product_image(product_image)
                .title(title)
                .address(address)
                .price(price)
                .build();
    }
}
