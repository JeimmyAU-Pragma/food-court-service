package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.domain.api.IDishServicePort;
import com.pragma.foodcourt.domain.command.DishUpdateCommand;
import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;

import java.util.List;

import static com.pragma.foodcourt.domain.util.DomainConstants.*;


public class DishUseCase implements IDishServicePort {

    private final IDishPersistencePort dishPersistencePort;

    public DishUseCase(IDishPersistencePort dishPersistencePort) {
        this.dishPersistencePort = dishPersistencePort;
    }

    @Override
    public void saveDish(DishModel dishModel) {

        validate(dishModel);

        dishModel.setActive(true);

        dishPersistencePort.saveDish(dishModel);
    }

    private void validate(DishModel dishModel) {

        if (dishModel.getName() == null || dishModel.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del plato es obligatorio.");
        }

        if (dishModel.getPrice() == null || dishModel.getPrice() <= 0) {
            throw new DomainException(DISH_PRICE_POSITIVE);
        }

        if (dishModel.getDescription() == null || dishModel.getDescription().isBlank()) {
            throw new DomainException(DISH_DESCRIPTION_REQUIRED);
        }

        if (dishModel.getUrlImage() == null || dishModel.getUrlImage().isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen es obligatoria.");
        }

        if (dishModel.getCategory().getId() == null) {
            throw new IllegalArgumentException("La categoría es obligatoria.");
        }

        if (dishModel.getRestaurant().getId() == null) {
            throw new IllegalArgumentException("El id del restaurante es obligatorio.");
        }
        /*if (dishModel.getIdOwner() == null) {
            throw new IllegalArgumentException("El id del propietario es obligatorio.");
        }
        // la union entre los 3
        boolean isOwner = restaurantFeignPort.isOwner(dishModel.getIdRestaurant(), dishModel.getIdOwner());
        if (!isOwner) {
            throw new DomainException("El usuario no es el propietario del restaurante");
        }*/
    }

    @Override
    public List<DishModel> getAllDishes() {
        return dishPersistencePort.getAllDishes();
    }

    @Override
    public DishModel getDishById(Long dishId) {
        return dishPersistencePort.getDishById(dishId);
    }

    @Override
    public void updateDish(Long dishId, Long ownerId, DishUpdateCommand dishUpdate) {
        DishModel dish = dishPersistencePort.getDishById(dishId);
        if (dish == null) throw new DomainException(DISH_NOT_FOUND);

        Restaurant restaurant = dish.getRestaurant();
        Long restaurantOwnerId = (restaurant != null) ? restaurant.getIdOwner() : null;
        if (restaurantOwnerId == null || !restaurantOwnerId.equals(ownerId)) {
            throw new DomainException(OWNER_NOT_ALLOWED);
        }

        if (dishUpdate.price() != null) {
            if (dishUpdate.price() <= 0) throw new DomainException(DISH_PRICE_POSITIVE);
            dish.setPrice(dishUpdate.price());
        }
        if (dishUpdate.description() != null) {
            dish.setDescription(dishUpdate.description());
        }

        if (dishUpdate.active() != null) {
            dish.setActive(dishUpdate.active());
        }

        dishPersistencePort.updateDish(dish);

    }

}