package com.pragma.foodcourt.application.handler;

import com.pragma.foodcourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;

import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);

    List<RestaurantResponseDto> getAllRestaurants();

    boolean isOwner(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long idRestaurant);
}