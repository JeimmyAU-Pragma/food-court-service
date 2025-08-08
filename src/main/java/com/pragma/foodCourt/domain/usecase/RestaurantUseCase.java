package com.pragma.foodCourt.domain.usecase;

import com.pragma.foodCourt.application.dto.external.UserResponseDto;
import com.pragma.foodCourt.domain.api.IRestaurantServicePort;
import com.pragma.foodCourt.domain.exception.DomainException;
import com.pragma.foodCourt.domain.model.Restaurant;
import com.pragma.foodCourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodCourt.domain.spi.IUserFeignPort;

import java.util.List;
import java.util.Optional;
// Constants
import static com.pragma.foodCourt.domain.util.DomainConstants.*;


public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserFeignPort userFeignPort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserFeignPort userFeignPort) {

        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userFeignPort = userFeignPort;
    }

    @Override
    public boolean isOwner(Long idRestaurant, Long idOwner) {
        return restaurantPersistencePort.isOwner(idRestaurant, idOwner);
    }

    @Override
    public void deleteRestaurant(Long idRestaurant) {
        restaurantPersistencePort.deleteRestaurant(idRestaurant);
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        UserResponseDto user = userFeignPort.getAuthenticatedUser();
        if (!ROLE_ADMIN.equals(user.getRol())) {
            throw new DomainException(MESSAGE_ERROR_ADMIN);
        }

        UserResponseDto userOwner = userFeignPort.getUserById(restaurant.getIdOwner());
        if (!userOwner.getRol().equals(ROLE_OWNER)) {
            throw new DomainException(MESSAGE_ERROR_OWNER);
        }

        validate(restaurant);
        restaurantPersistencePort.saveRestaurant(restaurant);
    }

    private void validate(Restaurant restaurant) {
        if (!restaurant.getPhoneNumber().matches("^\\+?\\d{1,13}$")) {
            throw new DomainException(INVALID_PHONE_NUMBER);
        }
        if (!restaurant.getNit().matches("\\d+")) {
            throw new DomainException(NIT_INVALID);
        }
        if (restaurant.getName().matches("\\d+")) {
            throw new DomainException(NAME_INVALID);
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantPersistencePort.getAllRestaurants();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long idRestaurant) {
        return restaurantPersistencePort.getRestaurantById(idRestaurant);
    }
}