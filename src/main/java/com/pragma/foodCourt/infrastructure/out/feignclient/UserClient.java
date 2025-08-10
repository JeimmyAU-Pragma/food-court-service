package com.pragma.foodcourt.infrastructure.out.feignclient;

import com.pragma.foodcourt.application.dto.external.UserResponseDto;
import com.pragma.foodcourt.infrastructure.configuration.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-service",
        url = "${users.service.url}",
        configuration = FeignClientConfig.class
)
public interface UserClient {

    @GetMapping("/api/v1/user/{id}")
    UserResponseDto getUserById(@PathVariable("id") Long id);

    @GetMapping("/auth/me")
    UserResponseDto getUserAuthenticated();
}
