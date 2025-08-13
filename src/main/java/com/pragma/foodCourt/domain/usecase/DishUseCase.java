package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.domain.api.IDishServicePort;

import com.pragma.foodcourt.domain.command.DishUpdateCommand;

import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.domain.util.PageResult;

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
            throw new DomainException(DISH_NAME_REQUIRED);
        }

        if (dishModel.getPrice() == null || dishModel.getPrice() <= 0) {

            throw new DomainException(DISH_PRICE_POSITIVE);

        }

        if (dishModel.getDescription() == null || dishModel.getDescription().isBlank()) {
            throw new DomainException(DISH_DESCRIPTION_REQUIRED);
        }

        if (dishModel.getUrlImage() == null || dishModel.getUrlImage().isBlank()) {
            throw new DomainException(DISH_IMAGE_URL_REQUIRED);
        }

        if (dishModel.getCategory().getId() == null) {
            throw new DomainException(DISH_CATEGORY_REQUIRED);
        }

        if (dishModel.getRestaurant().getId() == null) {
            throw new DomainException(DISH_RESTAURANT_ID_REQUIRED);
        }
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
    @Override
    public PageResult<DishModel> listByRestaurant(Long restaurantId, int page, int size, Long categoryId) {
        return dishPersistencePort.listByRestaurant(restaurantId, page, size, categoryId);
    }
    /*@Override
    public PageResult<DishModel> getDishes(int page, int size) {
        return dishPersistencePort.findAllDishesPaged(page, size, "name", true);
    }*/
    @Override
    public List<DishModel> getAllDishes() {
        return dishPersistencePort.getAllDishes();
    }

}