package com.pragma.foodCourt.application.handler.impl;

import com.pragma.foodCourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodCourt.application.dto.response.RestaurantResponseDto;
import com.pragma.foodCourt.application.handler.IRestaurantHandler;
import com.pragma.foodCourt.application.mapper.IRestaurantRequestMapper;
import com.pragma.foodCourt.application.mapper.IRestaurantResponseMapper;
import com.pragma.foodCourt.domain.api.IRestaurantServicePort;
import com.pragma.foodCourt.domain.model.Restaurant;
import com.pragma.foodCourt.infrastructure.exception.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRequestMapper.toRestaurant(restaurantRequestDto);
        restaurantServicePort.saveRestaurant(restaurant);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }

    @Override
    public boolean isOwner(Long idRestaurant, Long idOwner) {
        boolean result;
        result = restaurantServicePort.isOwner(idRestaurant, idOwner);
        return result;
    }


    @Override
    public void deleteRestaurant(Long idRestaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantServicePort.getRestaurantById(idRestaurant);
        if (!optionalRestaurant.isPresent()) {
            throw new NoDataFoundException("Restaurante no encontrado");
        }
        restaurantServicePort.deleteRestaurant(idRestaurant);
    }

}

