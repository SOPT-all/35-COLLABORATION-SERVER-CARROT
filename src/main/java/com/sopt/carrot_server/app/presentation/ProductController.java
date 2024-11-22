package com.sopt.carrot_server.app.presentation;

import com.sopt.carrot_server.app.application.ProductService;
import com.sopt.carrot_server.app.dto.response.ProductDetailResponse;
import com.sopt.carrot_server.global.common.code.SuccessCode;
import com.sopt.carrot_server.global.common.dto.SuccessResponse;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<SuccessResponse<ProductDetailResponse>> getDetailInfo(@PathVariable Long productId){
        ProductDetailResponse ProductResponse = productService.getDetailInfo(productId);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_GET_PRODUCT_DETAIL,ProductResponse));
    }
}
