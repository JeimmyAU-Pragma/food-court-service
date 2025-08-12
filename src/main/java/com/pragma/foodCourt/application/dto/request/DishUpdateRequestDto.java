package com.pragma.foodcourt.application.dto.request;

public record DishUpdateRequestDto(
        Long price,
        String description,
        Boolean active
) {}
