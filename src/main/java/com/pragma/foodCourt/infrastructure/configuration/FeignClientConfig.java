package com.pragma.foodcourt.infrastructure.configuration;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {


    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && auth.getCredentials() instanceof String token) {
                template.header("Authorization", "Bearer " + token);
            }
        };
    }
}
