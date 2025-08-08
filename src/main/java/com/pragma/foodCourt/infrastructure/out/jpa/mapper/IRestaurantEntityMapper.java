package com.pragma.foodCourt.infrastructure.out.jpa.mapper;


import com.pragma.foodCourt.domain.model.Restaurant;
import com.pragma.foodCourt.infrastructure.out.jpa.entity.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IRestaurantEntityMapper {

    RestaurantEntity toEntity(Restaurant restaurant);
    Restaurant toRestaurant(RestaurantEntity objectEntity);
    List<Restaurant> toRestaurantList(List<RestaurantEntity> userEntityList);
}