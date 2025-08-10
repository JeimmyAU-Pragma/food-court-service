package com.pragma.foodcourt.domain.spi;



import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IDishPersistencePort {
    DishModel saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    DishModel getDishById(Long dishId);

    void updateDish(DishModel dishId);

}