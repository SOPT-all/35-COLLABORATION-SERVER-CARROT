package com.sopt.carrot_server.app.mapper;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.dto.response.ProductDetailResponse;

public class ProductMapper {
    public static ProductDetailResponse toProductDetailResponseDTO(Product product){
        return ProductDetailResponse.builder()
                .productId(product.getId())
                .productImage(product.getProductImage())
                .title(product.getTitle())
                .category(product.getCategory())
                .content(product.getContent())
                .price(product.getPrice())
                .view(product.getView())
                .build();
    }
}
