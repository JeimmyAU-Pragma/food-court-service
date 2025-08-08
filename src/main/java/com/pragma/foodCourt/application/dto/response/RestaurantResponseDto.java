package com.pragma.foodCourt.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {
    private Long idRestaurant;
    private String name;
    private String nit;
    private String adress;
    private String phoneNumber;
    private String urlLogo;
    private Long idOwner;
}
