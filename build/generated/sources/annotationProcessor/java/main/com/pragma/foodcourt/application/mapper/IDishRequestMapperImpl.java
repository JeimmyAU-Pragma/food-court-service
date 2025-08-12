package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.DishRequestDto;
import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T08:29:35-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IDishRequestMapperImpl implements IDishRequestMapper {

    @Override
    public DishModel toDish(DishRequestDto dishRequestDto) {
        if ( dishRequestDto == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setCategory( dishRequestDtoToCategoryModel( dishRequestDto ) );
        dishModel.setRestaurant( dishRequestDtoToRestaurant( dishRequestDto ) );
        dishModel.setName( dishRequestDto.getName() );
        dishModel.setPrice( dishRequestDto.getPrice() );
        dishModel.setDescription( dishRequestDto.getDescription() );
        dishModel.setUrlImage( dishRequestDto.getUrlImage() );
        dishModel.setActive( dishRequestDto.getActive() );

        return dishModel;
    }

    protected CategoryModel dishRequestDtoToCategoryModel(DishRequestDto dishRequestDto) {
        if ( dishRequestDto == null ) {
            return null;
        }

        Long id = null;

        id = dishRequestDto.getCategoryId();

        String name = null;
        String description = null;

        CategoryModel categoryModel = new CategoryModel( id, name, description );

        return categoryModel;
    }

    protected Restaurant dishRequestDtoToRestaurant(DishRequestDto dishRequestDto) {
        if ( dishRequestDto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( dishRequestDto.getRestaurantId() );

        return restaurant;
    }
}
