package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.response.RestaurantListItemDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurant);

    List<RestaurantResponseDto> toResponseList(List<Restaurant> restaurantModelList);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "urlLogo", source = "urlLogo")
    RestaurantListItemDto toListItem(Restaurant restaurant);
}
