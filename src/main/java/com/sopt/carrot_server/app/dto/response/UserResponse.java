package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private Long userId;
    private String nickname;
    private String profileImage;
    private String address;
}
