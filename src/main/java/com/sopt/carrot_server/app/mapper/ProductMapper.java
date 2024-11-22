package com.sopt.carrot_server.app.mapper;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.enums.ProductSatus;
import com.sopt.carrot_server.app.dto.response.ProductCategoryListResponse;
import com.sopt.carrot_server.app.dto.response.SearchProductDetailResponse;
import com.sopt.carrot_server.app.dto.response.SearchProductListResponse;
import com.sopt.carrot_server.app.dto.response.UserSellingProductDetailResponse;
import com.sopt.carrot_server.app.dto.response.UserSellingProductListResponse;

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

    public static UserSellingProductListResponse fromUserSellingProducts(final List<Product> products) {
        return UserSellingProductListResponse.of(products.stream()
                .map(product -> UserSellingProductDetailResponse.of(
                        product.getId(),
                        product.getProductImage(),
                        product.getTitle(),
                        product.getPrice()
                )).toList()
        );
    }

    public static ProductCategoryListResponse getProductCategories(List<String> categories) {
        return ProductCategoryListResponse.of(categories);
    }
}
