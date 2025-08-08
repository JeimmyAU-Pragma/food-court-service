package com.pragma.foodCourt.infrastructure.out.adapter;

import com.pragma.foodCourt.application.dto.external.UserResponseDto;
import com.pragma.foodCourt.domain.spi.IUserFeignPort;
import com.pragma.foodCourt.infrastructure.out.feignclient.UserClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserFeignAdapter implements IUserFeignPort {
    private final UserClient userClient;

    @Override
    public UserResponseDto getUserById(Long id) {
        return userClient.getUserById(id);
    }
    public UserResponseDto getAuthenticatedUser() {
        return userClient.getUserAuthenticated();
    }
}
