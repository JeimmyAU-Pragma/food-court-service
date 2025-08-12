package com.pragma.foodcourt.infrastructure.out.jpa.mapper;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",

        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE

)
public interface IDishEntityMapper {

    DishEntity toEntity(DishModel dishModel);
//    @Mapping(target = "category", source = "category")
//    @Mapping(target = "restaurant", source = "restaurant")
    DishModel toDish(DishEntity dishEntity);
    List<DishModel> toDishList(List<DishEntity> userEntityList);

    void updateEntityFromModel(DishModel source, @MappingTarget DishEntity target);
}