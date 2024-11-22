package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record UserSellingProductDetailResponse(
        Long id,
        String product_image,
        String title,
        String price
) {
    public static UserSellingProductDetailResponse of(
            final Long id,
            final String product_image,
            final String title,
            final String price
    ) {
        return UserSellingProductDetailResponse.builder()
                .id(id)
                .product_image(product_image)
                .title(title)
                .price(price)
                .build();
    }
}
