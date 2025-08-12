package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.request.RestaurantRequestDto;
import com.pragma.foodcourt.domain.model.Restaurant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T11:26:39-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IRestaurantRequestMapperImpl implements IRestaurantRequestMapper {

    @Override
    public Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto) {
        if ( restaurantRequestDto == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setName( restaurantRequestDto.getName() );
        restaurant.setNit( restaurantRequestDto.getNit() );
        restaurant.setAddress( restaurantRequestDto.getAddress() );
        restaurant.setPhoneNumber( restaurantRequestDto.getPhoneNumber() );
        restaurant.setUrlLogo( restaurantRequestDto.getUrlLogo() );
        restaurant.setIdOwner( restaurantRequestDto.getIdOwner() );

        return restaurant;
    }
}
