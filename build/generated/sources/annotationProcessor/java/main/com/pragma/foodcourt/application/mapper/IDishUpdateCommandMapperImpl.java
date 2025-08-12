package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.DishUpdateRequestDto;
import com.pragma.foodcourt.domain.command.DishUpdateCommand;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T11:26:39-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishUpdateCommandMapperImpl implements IDishUpdateCommandMapper {

    @Override
    public DishUpdateCommand toCommand(DishUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Long price = null;
        String description = null;
        Boolean active = null;

        price = dto.price();
        description = dto.description();
        active = dto.active();

        DishUpdateCommand dishUpdateCommand = new DishUpdateCommand( price, description, active );

        return dishUpdateCommand;
    }
}
