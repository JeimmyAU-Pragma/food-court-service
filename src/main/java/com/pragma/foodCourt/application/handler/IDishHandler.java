package com.pragma.foodcourt.application.handler;


import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.application.dto.response.DishResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDishHandler {

    void saveDish(DishRequestDto dishRequestDto);

    List<DishResponseDto> getAllDishes();

    Page<DishResponseDto> listDishes(Long restaurantId, int page, int size, Long categoryId);

    void updateDish(Long dishId, Long ownerId, DishUpdateRequestDto request);

}