package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface IRestaurantServicePort {

    void saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Optional<Restaurant> getRestaurantById(Long idRestaurant);

    boolean isOwner(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long id);
}