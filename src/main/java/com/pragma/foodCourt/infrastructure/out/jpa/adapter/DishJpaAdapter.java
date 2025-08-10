package com.pragma.foodcourt.infrastructure.out.jpa.adapter;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IDishRepository;
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
        Optional<DishEntity> userEntity = dishRepository.findById(dishId);
        return dishEntityMapper.toDish(userEntity.orElse(null));
    }

    @Override
    public void updateDish(DishModel dishModel) {
        DishEntity dishEntity = dishEntityMapper.toEntity(dishModel);
        dishRepository.save(dishEntity);
    }

}