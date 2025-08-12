package com.pragma.foodcourt.domain.spi;


import com.pragma.foodcourt.domain.model.Restaurant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IRestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Page<Restaurant> findAllPaged(int page, int size, String sortBy, boolean asc);


    boolean isOwnerOfRestaurant(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long idRestaurant);

    Optional<Restaurant> findById(Long id);

    // Optional<Restaurant> getRestaurantById(Long idRestaurant);
}