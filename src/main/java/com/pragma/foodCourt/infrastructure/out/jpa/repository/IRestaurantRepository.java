package com.pragma.foodCourt.infrastructure.out.jpa.repository;

import com.pragma.foodCourt.domain.model.Restaurant;
import com.pragma.foodCourt.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    boolean existsByIdRestaurantAndIdOwner(Long idRestaurant, Long idOwner);

    Optional<Restaurant> getByIdRestaurant(Long idRestaurant);
}