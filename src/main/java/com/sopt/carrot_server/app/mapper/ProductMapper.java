package com.sopt.carrot_server.app.mapper;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.dto.response.SearchProductDetailResponse;
import com.sopt.carrot_server.app.dto.response.SearchProductListResponse;

import java.util.List;

public class ProductMapper {

    public static SearchProductListResponse toSearchProductListDTO(
            final List<Product> relatedProducts,
            final List<Product> similarProducts
    ) {
        return new SearchProductListResponse(
                fromProducts(relatedProducts),
                fromSimilarProducts(similarProducts)
        );
    }

    public static List<SearchProductDetailResponse> fromProducts(List<Product> products) {
        return products.stream()
                .map(product -> SearchProductDetailResponse.of(
                        product.getId(),
                        product.getUser().getId(),
                        product.getProductImage(),
                        product.getTitle(),
                        product.getUser().getAddress().getDong(),
                        product.getPrice()
                )).toList();
    }

    public static List<SearchProductDetailResponse> fromSimilarProducts(final List<Product> similarProducts) {
        return similarProducts.stream()
                .map(product -> SearchProductDetailResponse.of(
                        product.getId(),
                        product.getUser().getId(),
                        product.getProductImage(),
                        product.getTitle(),
                        product.getUser().getAddress().getDong(),
                        product.getPrice()
                )).toList();
    }
}
