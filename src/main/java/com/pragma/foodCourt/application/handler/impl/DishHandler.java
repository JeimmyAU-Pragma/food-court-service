package com.pragma.foodcourt.application.handler.impl;


import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.application.dto.response.DishResponseDto;
import com.pragma.foodcourt.application.handler.IDishHandler;
import com.pragma.foodcourt.application.mapper.IDishRequestMapper;
import com.pragma.foodcourt.application.mapper.IDishResponseMapper;
import com.pragma.foodcourt.domain.api.IDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DishHandler implements IDishHandler {

    private final IDishServicePort dishServicePort;
    private final IDishRequestMapper dishRequestMapper;
    private final IDishResponseMapper dishResponseMapper;



    @Override
    public void saveDish(DishRequestDto dishRequestDto) {
        DishModel dishModel = dishRequestMapper.toDish(dishRequestDto);
        dishServicePort.saveDish(dishModel);

    }

    @Override
    public List<DishResponseDto> getAllDishes() {
        return dishResponseMapper.toResponseList(dishServicePort.getAllDishes());
    }

    @Override
    public void updateDish(Long dishId, Long ownerId, DishUpdateRequestDto request) {
        dishServicePort.updateDish(dishId, ownerId, request);
    }


}