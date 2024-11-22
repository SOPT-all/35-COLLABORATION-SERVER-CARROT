package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.Address;
import com.sopt.carrot_server.app.domain.Product;
import com.sopt.carrot_server.app.domain.User;
import com.sopt.carrot_server.app.domain.enums.ProductSatus;
import com.sopt.carrot_server.app.domain.repository.AddressRepository;
import com.sopt.carrot_server.app.domain.repository.ProductRepository;
import com.sopt.carrot_server.app.domain.repository.UserRepository;
import com.sopt.carrot_server.app.dto.response.UserResponse;
import com.sopt.carrot_server.app.dto.response.UserSellingProductListResponse;
import com.sopt.carrot_server.app.mapper.ProductMapper;
import com.sopt.carrot_server.app.mapper.UserMapper;

import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.exception.AddressException;
import com.sopt.carrot_server.global.common.exception.UserException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public UserResponse getUserById(Long userId){

        //1. 유저 조회
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(FailureCode.USER_NOT_FOUND));

        //2. 주소 조회
        Address address = addressRepository.findById(user.getAddress().getId()).orElseThrow(()-> new AddressException(FailureCode.INVALID_VALUE));

        return UserMapper.toResponse(user,address);

    }

    public UserSellingProductListResponse getUserSellingProducts(final Long userId) {
        List<Product> productsByUser = productRepository.findProductsByUser(getUser(userId), ProductSatus.FOR_SALE);
        return ProductMapper.fromUserSellingProducts(productsByUser);
    }

    private User getUser(final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserException(FailureCode.USER_NOT_FOUND));
    }
}
