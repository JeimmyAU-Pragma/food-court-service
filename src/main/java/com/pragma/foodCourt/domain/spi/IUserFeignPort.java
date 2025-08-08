package com.pragma.foodcourt.domain.spi;


import com.pragma.foodcourt.application.dto.external.UserResponseDto;

public interface IUserFeignPort {
    UserResponseDto getUserById(Long id);
    UserResponseDto getAuthenticatedUser();
}
