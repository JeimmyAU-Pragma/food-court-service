package com.pragma.foodcourt.infrastructure.configuration;

import com.pragma.foodcourt.domain.api.IDishServicePort;
import com.pragma.foodcourt.domain.api.IRestaurantServicePort;
import com.pragma.foodcourt.domain.spi.IDishPersistencePort;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.spi.IUserFeignPort;
import com.pragma.foodcourt.domain.usecase.DishUseCase;
import com.pragma.foodcourt.domain.usecase.RestaurantUseCase;
import com.pragma.foodcourt.infrastructure.out.adapter.UserFeignAdapter;
import com.pragma.foodcourt.infrastructure.out.feignclient.UserClient;
import com.pragma.foodcourt.infrastructure.out.jpa.adapter.DishJpaAdapter;
import com.pragma.foodcourt.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IDishEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IDishRepository;
import com.pragma.foodcourt.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort(IRestaurantRepository restaurantRepository,
                                                                IRestaurantEntityMapper restaurantEntityMapper ) {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IUserFeignPort userFeignPort(UserClient userClient) {
        return new UserFeignAdapter(userClient);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort(IRestaurantPersistencePort restaurantPersistencePort,
                                                        IUserFeignPort userFeignPort) {
        return new RestaurantUseCase(restaurantPersistencePort,userFeignPort);
    }

    @Bean
    public IDishPersistencePort dishPersistencePort(IDishRepository dishRepository,
                                                    IDishEntityMapper dishEntityMapper) {
        return new DishJpaAdapter(dishRepository, dishEntityMapper);
    }

    @Bean
    public IDishServicePort dishServicePort(IDishPersistencePort dishPersistencePort) {
        return new DishUseCase(dishPersistencePort);
    }


}