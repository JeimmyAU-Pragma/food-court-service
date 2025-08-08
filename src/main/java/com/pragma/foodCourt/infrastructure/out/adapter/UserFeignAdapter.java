package com.pragma.foodcourt.infrastructure.out.adapter;

import com.pragma.foodcourt.application.dto.external.UserResponseDto;
import com.pragma.foodcourt.domain.spi.IUserFeignPort;
import com.pragma.foodcourt.infrastructure.out.feignclient.UserClient;
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
