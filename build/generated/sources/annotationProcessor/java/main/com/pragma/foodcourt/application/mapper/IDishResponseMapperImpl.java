package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.response.DishResponseDto;
import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T11:26:39-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishResponseMapperImpl implements IDishResponseMapper {

    @Override
    public DishResponseDto toResponse(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishResponseDto dishResponseDto = new DishResponseDto();

        dishResponseDto.setCategory( dishModelCategoryId( dishModel ) );
        dishResponseDto.setIdRestaurant( dishModelRestaurantId( dishModel ) );
        dishResponseDto.setId( dishModel.getId() );
        dishResponseDto.setName( dishModel.getName() );
        dishResponseDto.setPrice( dishModel.getPrice() );
        dishResponseDto.setDescription( dishModel.getDescription() );
        dishResponseDto.setUrlImage( dishModel.getUrlImage() );
        dishResponseDto.setActive( dishModel.getActive() );

        return dishResponseDto;
    }

    @Override
    public List<DishResponseDto> toResponseList(List<DishModel> dishesModelList) {
        if ( dishesModelList == null ) {
            return null;
        }

        List<DishResponseDto> list = new ArrayList<DishResponseDto>( dishesModelList.size() );
        for ( DishModel dishModel : dishesModelList ) {
            list.add( toResponse( dishModel ) );
        }

        return list;
    }

    private Long dishModelCategoryId(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }
        CategoryModel category = dishModel.getCategory();
        if ( category == null ) {
            return null;
        }
        Long id = category.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long dishModelRestaurantId(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }
        Restaurant restaurant = dishModel.getRestaurant();
        if ( restaurant == null ) {
            return null;
        }
        Long id = restaurant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
