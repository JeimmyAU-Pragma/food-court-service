package com.pragma.foodcourt.application.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponseDto {
    private Long id;
    private String name;
    private Long price;
    private String description;
    private String urlImage;
    private Long category;
    private Boolean active;
    private Long idRestaurant;
}
