package com.sopt.carrot_server.app.presentation;

import com.sopt.carrot_server.app.application.SearchService;
import com.sopt.carrot_server.global.common.code.SuccessCode;
import com.sopt.carrot_server.global.common.dto.SuccessResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SerachController {

    private final SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<SuccessResponse> searchProducts(
            @RequestParam(value = "keyword", required = false) String keyword
    ) {
        return ResponseEntity.ok(
                SuccessResponse.of(SuccessCode.SUCCESS_SEARCH_PRODUCTS, searchService.searchProducts(keyword))
        );
    }
}
