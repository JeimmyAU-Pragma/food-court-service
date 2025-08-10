package com.pragma.foodcourt.infrastructure.out.jpa.mapper;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IDishEntityMapper {

    DishEntity toEntity(DishModel dishModel);
    DishModel toDish(DishEntity dishEntity);
    List<DishModel> toDishList(List<DishEntity> userEntityList);
}