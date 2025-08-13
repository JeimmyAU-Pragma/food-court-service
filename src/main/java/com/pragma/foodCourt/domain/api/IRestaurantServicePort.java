package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.util.PageResult;

import java.util.List;
import java.util.Optional;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    PageResult<Restaurant> getRestaurants(int page, int size);

    Optional<Restaurant> getRestaurantById(Long id);

    void deleteRestaurant(Long id);
}