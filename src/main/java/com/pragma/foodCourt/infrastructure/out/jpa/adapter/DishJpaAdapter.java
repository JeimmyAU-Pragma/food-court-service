package com.pragma.foodcourt.infrastructure.out.jpa.adapter;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IDishRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class DishJpaAdapter implements IDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public DishModel saveDish(DishModel dishModel) {
        DishEntity dishEntity = dishRepository.save(dishEntityMapper.toEntity(dishModel));
        return dishEntityMapper.toDish(dishEntity);
    }

    @Override
    public List<DishModel> getAllDishes() {
        List<DishEntity> entityList = dishRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return dishEntityMapper.toDishList(entityList);
    }

    @Override
    public DishModel getDishById(Long dishId) {
        Optional<DishEntity> Entity = dishRepository.findById(dishId);
        return dishEntityMapper.toDish(Entity.orElse(null));
    }

    @Override
    public void updateDish(DishModel dishModel) {
//        if (dishModel.getId() == null) {
//            throw new IllegalArgumentException("Dish ID is required for update");
//        }
        DishEntity entity = dishRepository.findById(dishModel.getId())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found: " + dishModel.getId()));

        dishEntityMapper.updateEntityFromModel(dishModel, entity);


        dishRepository.save(entity);
    }

}