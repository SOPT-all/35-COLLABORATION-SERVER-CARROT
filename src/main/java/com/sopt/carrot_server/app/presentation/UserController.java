package com.sopt.carrot_server.app.presentation;

import com.sopt.carrot_server.app.application.UserService;
import com.sopt.carrot_server.app.dto.response.UserResponse;
import com.sopt.carrot_server.app.dto.response.UserSellingProductListResponse;
import com.sopt.carrot_server.global.common.code.SuccessCode;
import com.sopt.carrot_server.global.common.dto.SuccessResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<SuccessResponse<UserResponse>> getUserById(@PathVariable Long userId){
        UserResponse userResponse = userService.getUserById(userId);
        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_GET_USER_DETAIL,userResponse));

    }

    @GetMapping("/users/{userId}/selling-products")
    public ResponseEntity<SuccessResponse> getUserSellingProducts(@PathVariable Long userId) {
        UserSellingProductListResponse userSellingProducts = userService.getUserSellingProducts(userId);
        return ResponseEntity.ok(SuccessResponse.of(
                SuccessCode.SUCCESS_GET_USER_SELLING_PRODUCTS,
                userSellingProducts)
        );
    }

}
