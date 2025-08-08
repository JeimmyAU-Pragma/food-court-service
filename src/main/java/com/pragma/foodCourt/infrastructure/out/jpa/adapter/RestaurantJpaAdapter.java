package com.pragma.foodcourt.infrastructure.out.jpa.adapter;

import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
        return restaurantEntityMapper.toRestaurant(restaurantEntity);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
            List<RestaurantEntity> entityList = restaurantRepository.findAll();
            if (entityList.isEmpty()) {
                throw new NoDataFoundException("Restaurante no encontrado");
            }
            return restaurantEntityMapper.toRestaurantList(entityList);
    }
    @Override
    public boolean isOwner(Long idRestaurant, Long idOwner) {
        return restaurantRepository.existsByIdRestaurantAndIdOwner(idRestaurant, idOwner);
    }

    @Override
    public void deleteRestaurant(Long idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long idRestaurant) {
        return restaurantRepository.getByIdRestaurant(idRestaurant);//.map(restaurantEntityMapper::toRestaurant);
    }
}