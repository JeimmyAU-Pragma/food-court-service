package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.domain.api.IDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;

import java.util.List;

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

    private void validate(DishModel dishModel){

        if (dishModel.getName() == null || dishModel.getName().isBlank()) {
            throw new IllegalArgumentException("El nombre del plato es obligatorio.");
        }

        if (dishModel.getPrice() == null || dishModel.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio debe ser un número entero positivo mayor a 0.");
        }

        if (dishModel.getDescription() == null || dishModel.getDescription().isBlank()) {
            throw new IllegalArgumentException("La descripción del plato es obligatoria.");
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
    public void updateDish(Long dishId, Long ownerId, DishUpdateRequestDto request) {
        DishModel dish = dishPersistencePort.getDishById(dishId);

        dish.setPrice(request.getPrice());
        dish.setDescription(request.getDescription());

        dishPersistencePort.updateDish(dish);
    }

}