package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    @Mappings({
            @Mapping(target = "category.id", source = "categoryId"),
            @Mapping(target = "restaurant.id", source = "restaurantId"),
    })
    DishModel toDish(DishRequestDto dishRequestDto);

}
