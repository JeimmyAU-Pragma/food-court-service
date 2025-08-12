package com.pragma.foodcourt.application.handler;


import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.application.dto.response.DishResponseDto;

import java.util.List;

public interface IDishHandler {

    void saveDish(DishRequestDto dishRequestDto);

    List<DishResponseDto> getAllDishes();

    void updateDish(Long dishId,Long ownerId, DishUpdateRequestDto request);

    //DishResponseDto updateDishAndReturn(Long dishId, Long ownerId, DishUpdateRequestDto request);
}