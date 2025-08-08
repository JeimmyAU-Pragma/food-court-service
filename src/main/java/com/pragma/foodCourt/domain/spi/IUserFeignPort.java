package com.pragma.foodCourt.domain.spi;


import com.pragma.foodCourt.application.dto.external.UserResponseDto;

public interface IUserFeignPort {
    UserResponseDto getUserById(Long id);
    UserResponseDto getAuthenticatedUser();
}
