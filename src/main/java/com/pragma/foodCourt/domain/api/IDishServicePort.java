package com.pragma.foodcourt.domain.api;


import com.pragma.foodcourt.domain.command.DishUpdateCommand;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.util.PageResult;

import java.util.List;

public interface IDishServicePort {

    void saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    //PageResult<DishModel> getDishes(int page, int size);
    PageResult<DishModel> listByRestaurant(Long restaurantId, int page, int size, Long categoryId);

    DishModel getDishById(Long dishId);

    void updateDish(Long dishId, Long ownerId, DishUpdateCommand dishUpdate);

}