package com.sopt.carrot_server.app.mapper;

import com.sopt.carrot_server.app.domain.Address;
import com.sopt.carrot_server.app.domain.User;
import com.sopt.carrot_server.app.dto.response.UserResponse;

public class UserMapper {
    public static UserResponse toResponse(User user, Address address){
        return UserResponse.builder()
                .userId(user.getId())
                .nickname(user.getNickname())
                .profileImage(user.getProfileImage())
                .address(address.getDistrict() + " " + address.getDong())
                .build();
    }
}
