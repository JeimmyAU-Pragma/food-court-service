package com.pragma.foodcourt.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequestDto {
    private String name;
    private Long categoryId;
    private String description;
    private Long price;
    private Long restaurantId;
    private String urlImage;
    private Boolean active;
}
