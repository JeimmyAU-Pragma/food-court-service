package com.pragma.foodcourt.domain.spi;


import com.pragma.foodcourt.domain.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface IRestaurantPersistencePort {
    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    boolean isOwnerOfRestaurant(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long idRestaurant);

    Optional<Restaurant> findById(Long id);

    // Optional<Restaurant> getRestaurantById(Long idRestaurant);
}