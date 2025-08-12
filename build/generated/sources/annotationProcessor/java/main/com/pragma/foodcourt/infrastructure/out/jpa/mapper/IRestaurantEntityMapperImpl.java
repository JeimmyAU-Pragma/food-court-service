package com.pragma.foodcourt.infrastructure.out.jpa.mapper;

import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.RestaurantEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-12T08:29:35-0500",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 17.0.15 (Microsoft)"
)
@Component
public class IRestaurantEntityMapperImpl implements IRestaurantEntityMapper {

    @Override
    public RestaurantEntity toEntity(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        RestaurantEntity restaurantEntity = new RestaurantEntity();

        restaurantEntity.setId( restaurant.getId() );
        restaurantEntity.setName( restaurant.getName() );
        restaurantEntity.setNit( restaurant.getNit() );
        restaurantEntity.setAddress( restaurant.getAddress() );
        restaurantEntity.setPhoneNumber( restaurant.getPhoneNumber() );
        restaurantEntity.setUrlLogo( restaurant.getUrlLogo() );
        restaurantEntity.setIdOwner( restaurant.getIdOwner() );

        return restaurantEntity;
    }

    @Override
    public Restaurant toRestaurant(RestaurantEntity restaurantEntity) {
        if ( restaurantEntity == null ) {
            return null;
        }

        Restaurant restaurant = new Restaurant();

        restaurant.setId( restaurantEntity.getId() );
        restaurant.setName( restaurantEntity.getName() );
        restaurant.setNit( restaurantEntity.getNit() );
        restaurant.setAddress( restaurantEntity.getAddress() );
        restaurant.setPhoneNumber( restaurantEntity.getPhoneNumber() );
        restaurant.setUrlLogo( restaurantEntity.getUrlLogo() );
        restaurant.setIdOwner( restaurantEntity.getIdOwner() );

        return restaurant;
    }

    @Override
    public List<Restaurant> toRestaurantList(List<RestaurantEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<Restaurant> list = new ArrayList<Restaurant>( userEntityList.size() );
        for ( RestaurantEntity restaurantEntity : userEntityList ) {
            list.add( toRestaurant( restaurantEntity ) );
        }

        return list;
    }
}
