package com.pragma.foodcourt.domain.spi;



import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.util.PageResult;

import java.util.List;

public interface IDishPersistencePort {
    DishModel saveDish(DishModel dishModel);

    List<DishModel> getAllDishes();

    DishModel getDishById(Long dishId);

    void updateDish(DishModel dishId);

    //PageResult<DishModel> findAllDishesPaged(int page, int size, String sortBy, boolean asc);
    PageResult<DishModel> listByRestaurant(Long restaurantId, int page, int size, Long categoryId);
}