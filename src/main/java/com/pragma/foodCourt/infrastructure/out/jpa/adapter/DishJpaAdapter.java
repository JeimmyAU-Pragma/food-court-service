package com.pragma.foodcourt.infrastructure.out.jpa.adapter;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.domain.util.PageResult;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IDishRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        Optional<DishEntity> entity = dishRepository.findById(dishId);
        return dishEntityMapper.toDish(entity.orElse(null));
    }

    @Override
    public void updateDish(DishModel dishModel) {

        DishEntity entity = dishRepository.findById(dishModel.getId())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found: " + dishModel.getId()));

        dishEntityMapper.updateEntityFromModel(dishModel, entity);


        dishRepository.save(entity);
    }

 /*   @Override
    public PageResult<DishModel> findAllDishesPaged(int page, int size, String sortBy, boolean asc) {

        Sort sort;
        if (asc) sort = Sort.by(sortBy).ascending();
        else sort = Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<DishEntity> result = dishRepository.findAll(pageable);

        List<DishModel> items = dishEntityMapper.toDishList(result.getContent());
        return new PageResult<>(
                items,
                result.getNumber(),
                result.getSize(),
                result.getTotalElements()
        );
    }*/


    @Override
    public PageResult<DishModel> listByRestaurant(Long restaurantId, int page, int size, Long categoryId) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<DishEntity> result;
        if (categoryId != null) {
            result = dishRepository.findByRestaurantIdAndCategoryIdAndActiveTrue(restaurantId, categoryId, pageable);
        } else {
            result = dishRepository.findByRestaurantIdAndActiveTrue(restaurantId, pageable);
        }

        List<DishModel> items = dishEntityMapper.toDishList(result.getContent());
        return new PageResult<>(
                items,
                result.getNumber(),
                result.getSize(),
                result.getTotalElements()
        );
    }
}

