package com.pragma.foodcourt.application.handler.impl;

import com.pragma.foodcourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.application.dto.response.RestaurantListItemDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.application.handler.IRestaurantHandler;
import com.pragma.foodcourt.application.mapper.IRestaurantRequestMapper;
import com.pragma.foodcourt.application.mapper.IRestaurantResponseMapper;
import com.pragma.foodcourt.domain.api.IRestaurantServicePort;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.domain.util.PageResult;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = restaurantRequestMapper.toRestaurant(restaurantRequestDto);
        restaurantServicePort.saveRestaurant(restaurant);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }

//    @Override
//    public boolean isOwner(Long idRestaurant, Long idOwner) {
//        boolean result;
//        result = restaurantServicePort.isOwner(idRestaurant, idOwner);
//        return result;
//    }


    @Override
    public void deleteRestaurant(Long idRestaurant) {
        Optional<Restaurant> optionalRestaurant = restaurantServicePort.getRestaurantById(idRestaurant);
        if (!optionalRestaurant.isPresent()) {
            throw new NoDataFoundException();
        }
        restaurantServicePort.deleteRestaurant(idRestaurant);
    }

    @Override
    public Page<RestaurantListItemDto> listRestaurants(int page, int size) {
        PageResult<Restaurant> result = restaurantServicePort.getRestaurants(page, size);

        List<RestaurantListItemDto> items =
                restaurantResponseMapper.toListItems(result.items());

        return new PageImpl<>(
                items,
                PageRequest.of(result.page(), result.size()),
                result.total()
        );
    }

}

