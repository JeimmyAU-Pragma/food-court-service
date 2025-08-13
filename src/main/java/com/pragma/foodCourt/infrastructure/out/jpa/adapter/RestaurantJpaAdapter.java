package com.pragma.foodcourt.infrastructure.out.jpa.adapter;

import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.util.PageResult;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
        return restaurantEntityMapper.toRestaurant(restaurantEntity);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<RestaurantEntity> entityList = restaurantRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantList(entityList);
    }

    @Override
    public PageResult<Restaurant> findAllRestaurantPaged(int page, int size, String sortBy, boolean asc) {
        Sort sort;
        if (asc) sort = Sort.by(sortBy).ascending();
        else sort = Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<RestaurantEntity> result = restaurantRepository.findAll(pageable);

        List<Restaurant> items = restaurantEntityMapper.toRestaurantList(result.getContent());
        return new PageResult<>(
                items,
                result.getNumber(),
                result.getSize(),
                result.getTotalElements()
        );
    }

    @Override
    public boolean isOwnerOfRestaurant(Long idRestaurant, Long idOwner) {
        return restaurantRepository.existsByIdAndIdOwner(idRestaurant, idOwner);
    }


    @Override
    public void deleteRestaurant(Long idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id).map(restaurantEntityMapper::toRestaurant);
    }

}