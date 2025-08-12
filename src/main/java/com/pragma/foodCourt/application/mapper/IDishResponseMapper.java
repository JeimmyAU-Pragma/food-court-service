package com.pragma.foodcourt.application.mapper;


import com.pragma.foodcourt.application.dto.response.DishResponseDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishResponseMapper {

    @Mapping(target = "category", source = "category.id")
    @Mapping(target = "idRestaurant", source = "restaurant.id")
    DishResponseDto toResponse(DishModel dishModel);

    List<DishResponseDto> toResponseList(List<DishModel> dishesModelList);

}
