package com.pragma.foodcourt.infrastructure.out.jpa.repository;

import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
   // boolean existsByIdRestaurantAndIdOwner(Long idRestaurant, Long idOwner);
    Optional<RestaurantEntity> findById(Long id);
    //Optional<Restaurant> getByIdRestaurant(Long idRestaurant);
}