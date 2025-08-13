package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.response.RestaurantListItemDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;
import com.pragma.foodcourt.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {

    RestaurantResponseDto toResponse(Restaurant restaurant);

    List<RestaurantResponseDto> toResponseList(List<Restaurant> restaurantsModelList);

    List<RestaurantListItemDto> toListItems(List<Restaurant> restaurants);

    RestaurantListItemDto toListItem(Restaurant restaurant);

}
