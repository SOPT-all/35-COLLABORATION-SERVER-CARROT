package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.enums.Category;
import com.sopt.carrot_server.app.domain.enums.ProductSatus;
import com.sopt.carrot_server.app.dto.response.ProductCategoryListResponse;
import com.sopt.carrot_server.app.mapper.ProductMapper;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductCategoryListResponse getProductCategories() {
        return ProductMapper.getProductCategories(Category.getValues());
    }
}
