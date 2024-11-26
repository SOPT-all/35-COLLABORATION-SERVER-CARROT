package com.sopt.carrot_server.app.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private Long user_id;
    private String nickname;
    private String profile_image;
    private String address;
}
