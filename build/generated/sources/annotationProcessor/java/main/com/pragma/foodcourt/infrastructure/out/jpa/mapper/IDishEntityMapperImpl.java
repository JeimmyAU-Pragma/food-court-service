package com.pragma.foodcourt.infrastructure.out.jpa.mapper;

import com.pragma.foodcourt.domain.model.CategoryModel;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.model.Restaurant;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.CategoryEntity;
import com.pragma.foodcourt.infrastructure.out.jpa.entity.DishEntity;
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
public class IDishEntityMapperImpl implements IDishEntityMapper {

    @Override
    public DishEntity toEntity(DishModel dishModel) {
        if ( dishModel == null ) {
            return null;
        }

        DishEntity dishEntity = new DishEntity();

        dishEntity.setId( dishModel.getId() );
        dishEntity.setName( dishModel.getName() );
        dishEntity.setPrice( dishModel.getPrice() );
        dishEntity.setDescription( dishModel.getDescription() );
        dishEntity.setUrlImage( dishModel.getUrlImage() );
        dishEntity.setCategory( categoryModelToCategoryEntity( dishModel.getCategory() ) );
        dishEntity.setActive( dishModel.getActive() );
        dishEntity.setRestaurant( restaurantToRestaurantEntity( dishModel.getRestaurant() ) );

        return dishEntity;
    }

    @Override
    public DishModel toDish(DishEntity dishEntity) {
        if ( dishEntity == null ) {
            return null;
        }

        DishModel dishModel = new DishModel();

        dishModel.setId( dishEntity.getId() );
        dishModel.setName( dishEntity.getName() );
        dishModel.setPrice( dishEntity.getPrice() );
        dishModel.setDescription( dishEntity.getDescription() );
        dishModel.setUrlImage( dishEntity.getUrlImage() );
        dishModel.setActive( dishEntity.getActive() );
        dishModel.setRestaurant( restaurantEntityToRestaurant( dishEntity.getRestaurant() ) );
        dishModel.setCategory( categoryEntityToCategoryModel( dishEntity.getCategory() ) );

        return dishModel;
    }

    @Override
    public List<DishModel> toDishList(List<DishEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<DishModel> list = new ArrayList<DishModel>( userEntityList.size() );
        for ( DishEntity dishEntity : userEntityList ) {
            list.add( toDish( dishEntity ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromModel(DishModel source, DishEntity target) {
        if ( source == null ) {
            return;
        }

        if ( source.getId() != null ) {
            target.setId( source.getId() );
        }
        if ( source.getName() != null ) {
            target.setName( source.getName() );
        }
        if ( source.getPrice() != null ) {
            target.setPrice( source.getPrice() );
        }
        if ( source.getDescription() != null ) {
            target.setDescription( source.getDescription() );
        }
        if ( source.getUrlImage() != null ) {
            target.setUrlImage( source.getUrlImage() );
        }
        if ( source.getCategory() != null ) {
            if ( target.getCategory() == null ) {
                target.setCategory( new CategoryEntity() );
            }
            categoryModelToCategoryEntity1( source.getCategory(), target.getCategory() );
        }
        if ( source.getActive() != null ) {
            target.setActive( source.getActive() );
        }
        if ( source.getRestaurant() != null ) {
            if ( target.getRestaurant() == null ) {
                target.setRestaurant( new RestaurantEntity() );
            }
            restaurantToRestaurantEntity1( source.getRestaurant(), target.getRestaurant() );
        }
    }

    protected CategoryEntity categoryModelToCategoryEntity(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryModel.getId() );
        categoryEntity.setName( categoryModel.getName() );
        categoryEntity.setDescription( categoryModel.getDescription() );

        return categoryEntity;
    }

    protected RestaurantEntity restaurantToRestaurantEntity(Restaurant restaurant) {
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

    protected Restaurant restaurantEntityToRestaurant(RestaurantEntity restaurantEntity) {
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

    protected CategoryModel categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;

        id = categoryEntity.getId();
        name = categoryEntity.getName();
        description = categoryEntity.getDescription();

        CategoryModel categoryModel = new CategoryModel( id, name, description );

        return categoryModel;
    }

    protected void categoryModelToCategoryEntity1(CategoryModel categoryModel, CategoryEntity mappingTarget) {
        if ( categoryModel == null ) {
            return;
        }

        if ( categoryModel.getId() != null ) {
            mappingTarget.setId( categoryModel.getId() );
        }
        if ( categoryModel.getName() != null ) {
            mappingTarget.setName( categoryModel.getName() );
        }
        if ( categoryModel.getDescription() != null ) {
            mappingTarget.setDescription( categoryModel.getDescription() );
        }
    }

    protected void restaurantToRestaurantEntity1(Restaurant restaurant, RestaurantEntity mappingTarget) {
        if ( restaurant == null ) {
            return;
        }

        if ( restaurant.getId() != null ) {
            mappingTarget.setId( restaurant.getId() );
        }
        if ( restaurant.getName() != null ) {
            mappingTarget.setName( restaurant.getName() );
        }
        if ( restaurant.getNit() != null ) {
            mappingTarget.setNit( restaurant.getNit() );
        }
        if ( restaurant.getAddress() != null ) {
            mappingTarget.setAddress( restaurant.getAddress() );
        }
        if ( restaurant.getPhoneNumber() != null ) {
            mappingTarget.setPhoneNumber( restaurant.getPhoneNumber() );
        }
        if ( restaurant.getUrlLogo() != null ) {
            mappingTarget.setUrlLogo( restaurant.getUrlLogo() );
        }
        if ( restaurant.getIdOwner() != null ) {
            mappingTarget.setIdOwner( restaurant.getIdOwner() );
        }
    }
}
