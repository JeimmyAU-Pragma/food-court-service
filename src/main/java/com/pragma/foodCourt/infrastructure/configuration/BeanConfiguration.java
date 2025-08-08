package com.pragma.foodcourt.infrastructure.configuration;

import com.pragma.foodcourt.domain.api.IRestaurantServicePort;
import com.pragma.foodcourt.domain.spi.IRestaurantPersistencePort;
import com.pragma.foodcourt.domain.spi.IUserFeignPort;
import com.pragma.foodcourt.domain.usecase.RestaurantUseCase;
import com.pragma.foodcourt.infrastructure.out.adapter.UserFeignAdapter;
import com.pragma.foodcourt.infrastructure.out.feignclient.UserClient;
import com.pragma.foodcourt.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.pragma.foodcourt.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
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

}