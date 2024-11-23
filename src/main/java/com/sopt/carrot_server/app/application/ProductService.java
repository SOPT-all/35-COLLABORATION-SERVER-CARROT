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

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductCategoryListResponse getProductCategories() {
        return ProductMapper.getProductCategories(Category.getValues());
    }

    public ProductDetailResponse getDetailInfo(Long productId) {
        Product product = productRepository.findDetailInfoByProductId(productId)
                .orElseThrow(() -> new ProductException(FailureCode.INVALID_VALUE));
        return ProductMapper.toProductDetailResponseDTO(product);
    }

    public HomeProductListResponse getProductInfo(List<String> categories){
        List<Product> relatedProducts;
        if(categories !=null && !categories.isEmpty()){
            relatedProducts = productRepository.findProductsByCategories(categories);
        }else{
            relatedProducts = productRepository.findAll();
        }

        return ProductMapper.toHomeProductListDTO(relatedProducts);
    }

}
