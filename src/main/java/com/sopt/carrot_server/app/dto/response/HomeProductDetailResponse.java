package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;

import static lombok.AccessLevel.PRIVATE;

@Builder(access = PRIVATE)
public record HomeProductDetailResponse(
        Long id,
        Long user_id,
        String product_image,
        String title,
        String price,
        String address
) {
    public static HomeProductDetailResponse of(
            final Long id,
            final Long user_id,
            final String product_image,
            final String title,
            final String price,
            final String address
    ) {
        return HomeProductDetailResponse.builder()
                .id(id)
                .user_id(user_id)
                .product_image(product_image)
                .title(title)
                .price(price)
                .address(address)
                .build();
    }
}
