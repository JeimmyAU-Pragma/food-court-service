package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.command.DishUpdateCommand;
import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IDishServicePort {

    void saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    DishModel getDishById(Long dishId);

    void updateDish(Long dishId, Long ownerId, DishUpdateCommand dishUpdate);

}