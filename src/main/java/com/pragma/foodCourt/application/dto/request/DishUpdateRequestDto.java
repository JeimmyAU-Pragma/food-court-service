package com.pragma.foodcourt.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishUpdateRequestDto {
    private Long price;
    private String description;
}
