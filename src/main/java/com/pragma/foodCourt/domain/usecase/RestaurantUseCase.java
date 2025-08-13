package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.application.dto.external.UserResponseDto;
import com.pragma.foodcourt.domain.api.IRestaurantServicePort;
import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.spi.IUserFeignPort;
import com.pragma.foodcourt.domain.util.PageResult;

import java.util.List;
import java.util.Optional;

import static com.pragma.foodcourt.domain.util.DomainConstants.*;


public class RestaurantUseCase implements IRestaurantServicePort {

    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IUserFeignPort userFeignPort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort, IUserFeignPort userFeignPort) {

        this.restaurantPersistencePort = restaurantPersistencePort;
        this.userFeignPort = userFeignPort;
    }


    @Override
    public void deleteRestaurant(Long idRestaurant) {
        restaurantPersistencePort.deleteRestaurant(idRestaurant);
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        UserResponseDto user = userFeignPort.getAuthenticatedUser();

        String roleName = user != null
                && user.getRole() != null
                ? user.getRole().getName()
                : null;

        if (!ROLE_ADMIN.equalsIgnoreCase(roleName)) {
            throw new DomainException(MESSAGE_ERROR_ADMIN);
        }

        UserResponseDto userOwner = userFeignPort.getUserById(restaurant.getIdOwner());
        if (!userOwner.getRole().getName() .equals(ROLE_OWNER)) {
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
    public PageResult<Restaurant> getRestaurants(int page, int size) {
        return restaurantPersistencePort.findAllRestaurantPaged(page, size, "name", true);
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long idRestaurant) {
        return restaurantPersistencePort.findById(idRestaurant);
    }
}