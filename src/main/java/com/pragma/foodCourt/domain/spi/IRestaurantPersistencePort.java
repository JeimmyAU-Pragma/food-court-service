package com.pragma.foodCourt.domain.spi;


import com.pragma.foodCourt.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface IRestaurantPersistencePort {
    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    boolean isOwner(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long idRestaurant);

    Optional<Restaurant> getRestaurantById(Long idRestaurant);
}