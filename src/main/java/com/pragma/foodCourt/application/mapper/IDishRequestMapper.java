package com.pragma.foodcourt.application.mapper;



import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.domain.model.DishModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    DishModel toDish(DishRequestDto dishRequestDto);
}
