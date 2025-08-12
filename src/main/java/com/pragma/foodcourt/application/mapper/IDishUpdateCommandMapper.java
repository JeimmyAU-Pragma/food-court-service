package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.domain.command.DishUpdateCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDishUpdateCommandMapper {
    DishUpdateCommand toCommand(DishUpdateRequestDto dto);
}
