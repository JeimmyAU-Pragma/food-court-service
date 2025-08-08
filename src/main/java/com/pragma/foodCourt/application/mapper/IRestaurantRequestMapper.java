package com.pragma.foodCourt.application.mapper;

import com.pragma.foodCourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodCourt.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantRequestMapper {
    Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto);
}
