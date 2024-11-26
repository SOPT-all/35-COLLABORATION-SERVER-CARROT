package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.enums.Category;
import com.sopt.carrot_server.app.dto.response.HomeProductListResponse;
import com.sopt.carrot_server.app.dto.response.ProductCategoryListResponse;
import com.sopt.carrot_server.app.mapper.ProductMapper;
import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.repository.ProductRepository;
import com.sopt.carrot_server.app.dto.response.ProductDetailResponse;
import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.exception.ProductException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductCategoryListResponse getProductCategories() {
        return ProductMapper.getProductCategories(Category.getValues());
    }

    @Transactional(readOnly = true)
    public ProductDetailResponse getDetailInfo(Long productId) {
        Product product = productRepository.findDetailInfoByProductId(productId)
                .orElseThrow(() -> new ProductException(FailureCode.INVALID_VALUE));
        product.updateView();
        return ProductMapper.toProductDetailResponseDTO(product);
    }

    public HomeProductListResponse getProductInfo(List<String> categories) {
        List<Product> relatedProducts;

        List<String> englishCategories = categories != null && !categories.isEmpty() ? categories.stream().map(Category::fromKoreanToEnglish).toList() : null;

        log.info("Final English categories used for query: {}", englishCategories);
        if (englishCategories != null && !englishCategories.isEmpty()) {
            relatedProducts = productRepository.findProductsByCategories(englishCategories);
            log.info("Found {} products for categories: {}", relatedProducts.size(), englishCategories);
        } else {
            relatedProducts = productRepository.findAll();
        }

        return ProductMapper.toHomeProductListDTO(relatedProducts);
    }

}
