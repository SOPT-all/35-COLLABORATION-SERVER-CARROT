package com.sopt.carrot_server.app.dto.response;

import java.util.List;

public record ProductCategoryListResponse(
        List<String> categories
) {
    public static ProductCategoryListResponse of(List<String> cagetories) {
        return new ProductCategoryListResponse(cagetories);
    }
}
