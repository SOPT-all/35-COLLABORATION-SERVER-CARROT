package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.repository.ProductRepository;
import com.sopt.carrot_server.app.dto.response.ProductDetailResponse;
import com.sopt.carrot_server.app.mapper.ProductMapper;
import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.exception.ProductException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDetailResponse getDetailInfo(Long productId) {
        Product product = productRepository.findDetailInfoByProductId(productId)
                .orElseThrow(() -> new ProductException(FailureCode.INVALID_VALUE));
        return ProductMapper.toProductDetailResponseDTO(product);
    }
}
