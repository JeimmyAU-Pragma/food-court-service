package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
   // DishModel toDish(DishRequestDto dishRequestDto);
   @Mappings({
           @Mapping(target = "category", source = "categoryId", qualifiedByName = "toCategory"),
           @Mapping(target = "restaurant", source = "restaurantId", qualifiedByName = "toRestaurant")
   })
   DishModel toDish(DishRequestDto dto);

    @Named("toCategory")
    public static CategoryModel toCategory(Long id) {
        return id == null ? null : new CategoryModel(id);
    }

    @Named("toRestaurant")
    public static Restaurant toRestaurant(Long id) {
        return id == null ? null : new Restaurant(id);
    }
}
