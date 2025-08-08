package com.pragma.foodcourt.application.dto.external;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String rol;

    public UserResponseDto(Long userId, String firstName, String lastName, String rol) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rol = rol;
    }

}
