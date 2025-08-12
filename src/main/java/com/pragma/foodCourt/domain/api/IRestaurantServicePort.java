package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.Restaurant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Page<Restaurant> getRestaurants(int page, int size);


    Optional<Restaurant> getRestaurantById(Long id);

    void deleteRestaurant(Long id);
}