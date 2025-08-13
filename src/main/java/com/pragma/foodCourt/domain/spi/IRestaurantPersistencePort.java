package com.pragma.foodcourt.domain.spi;


import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.util.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IRestaurantPersistencePort {

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    PageResult<Restaurant> findAllRestaurantPaged(int page, int size, String sortBy, boolean asc);
   // PageResult<Restaurant> findAllRestaurants(int page, int size);

    boolean isOwnerOfRestaurant(Long idRestaurant, Long idOwner);

    void deleteRestaurant(Long idRestaurant);

    Optional<Restaurant> findById(Long id);

    // Optional<Restaurant> getRestaurantById(Long idRestaurant);
}