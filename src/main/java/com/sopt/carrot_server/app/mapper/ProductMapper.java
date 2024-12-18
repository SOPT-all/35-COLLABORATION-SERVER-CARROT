package com.sopt.carrot_server.app.mapper;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.enums.Category;
import com.sopt.carrot_server.app.dto.response.*;

import java.util.List;

public class ProductMapper {

    public static ProductDetailResponse toProductDetailResponseDTO(Product product) {
        return ProductDetailResponse.builder()
                .product_id(product.getId())
                .product_image(product.getProductImage())
                .title(product.getTitle())
                .category(Category.toKorean(product.getCategory()))
                .content(product.getContent())
                .price(product.getPrice())
                .view(product.getView())
                .build();
    }


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

    public static HomeProductListResponse toHomeProductListDTO(List<Product> products) {
        List<HomeProductDetailResponse> relatedProductDetails = products.stream()
                .map(product -> HomeProductDetailResponse.of(
                        product.getId(),
                        product.getUser().getId(),
                        product.getProductImage(),
                        product.getTitle(),
                        product.getPrice(),
                        product.getUser().getAddress().getDong(),
                        product.getView()
                ))
                .toList();

        return HomeProductListResponse.of(relatedProductDetails);
    }
}
