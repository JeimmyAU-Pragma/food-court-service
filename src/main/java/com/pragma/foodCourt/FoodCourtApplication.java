package com.pragma.foodCourt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.pragma.foodCourt.infrastructure.out.feignclient")
public class FoodCourtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCourtApplication.class, args);
	}

}
