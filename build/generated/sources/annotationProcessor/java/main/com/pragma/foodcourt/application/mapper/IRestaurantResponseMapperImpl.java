package com.pragma.foodcourt.application.mapper;

import com.pragma.foodcourt.application.dto.response.RestaurantListItemDto;
import com.pragma.foodcourt.application.dto.response.RestaurantResponseDto;
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
public class IRestaurantResponseMapperImpl implements IRestaurantResponseMapper {

    @Override
    public RestaurantResponseDto toResponse(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantResponseDto restaurantResponseDto = new RestaurantResponseDto();

        restaurantResponseDto.setId( restaurant.getId() );
        restaurantResponseDto.setName( restaurant.getName() );
        restaurantResponseDto.setNit( restaurant.getNit() );
        restaurantResponseDto.setAddress( restaurant.getAddress() );
        restaurantResponseDto.setPhoneNumber( restaurant.getPhoneNumber() );
        restaurantResponseDto.setUrlLogo( restaurant.getUrlLogo() );
        restaurantResponseDto.setIdOwner( restaurant.getIdOwner() );

        return restaurantResponseDto;
    }

    @Override
    public List<RestaurantResponseDto> toResponseList(List<Restaurant> restaurantModelList) {
        if ( restaurantModelList == null ) {
            return null;
        }

        List<RestaurantResponseDto> list = new ArrayList<RestaurantResponseDto>( restaurantModelList.size() );
        for ( Restaurant restaurant : restaurantModelList ) {
            list.add( toResponse( restaurant ) );
        }

        return list;
    }

    @Override
    public RestaurantListItemDto toListItem(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        String name = null;
        String urlLogo = null;

        name = restaurant.getName();
        urlLogo = restaurant.getUrlLogo();

        RestaurantListItemDto restaurantListItemDto = new RestaurantListItemDto( name, urlLogo );

        return restaurantListItemDto;
    }
}
