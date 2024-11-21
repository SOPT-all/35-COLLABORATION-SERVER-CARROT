package com.sopt.carrot_server.app.application;

import com.sopt.carrot_server.app.domain.Address;
import com.sopt.carrot_server.app.domain.User;
import com.sopt.carrot_server.app.domain.repository.AddressRepository;
import com.sopt.carrot_server.app.domain.repository.UserRepository;
import com.sopt.carrot_server.app.dto.response.UserResponse;
import com.sopt.carrot_server.app.mapper.UserMapper;

import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.exception.AddressException;
import com.sopt.carrot_server.global.common.exception.UserException;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository,AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserResponse getUserById(Long userId){

        //1. 유저 조회
        User user = userRepository.findById(userId).orElseThrow(()-> new UserException(FailureCode.USER_NOT_FOUND));

        //2. 주소 조회
        Address address = addressRepository.findById(user.getAddressId()).orElseThrow(()-> new AddressException(FailureCode.INVALID_VALUE));

        return UserMapper.toResponse(user,address);

    }
}
