package com.pragma.foodCourt.infrastructure.configuration;

import com.pragma.foodCourt.domain.api.IRestaurantServicePort;
import com.pragma.foodCourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodCourt.domain.spi.IUserFeignPort;
import com.pragma.foodCourt.domain.usecase.RestaurantUseCase;
import com.pragma.foodCourt.infrastructure.out.adapter.UserFeignAdapter;
import com.pragma.foodCourt.infrastructure.out.feignclient.UserClient;
import com.pragma.foodCourt.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.foodCourt.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.pragma.foodCourt.infrastructure.out.jpa.repository.IRestaurantRepository;
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

}