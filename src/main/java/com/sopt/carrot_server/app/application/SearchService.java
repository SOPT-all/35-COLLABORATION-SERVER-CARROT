package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.repository.AddressRepository;
import com.sopt.carrot_server.app.domain.repository.ProductRepository;
import com.sopt.carrot_server.app.dto.response.SearchProductListResponse;
import com.sopt.carrot_server.app.mapper.ProductMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;

    public SearchProductListResponse searchProducts(final String keyword) {
        return ProductMapper.toSearchProductListDTO(
                productRepository.findProductsByKeyword(keyword),
                productRepository.findSimilarProducts(keyword)
        );
    }
}
