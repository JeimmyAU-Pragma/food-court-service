package com.pragma.foodcourt.domain.command;


public record DishUpdateCommand(Long price, String description,Boolean active) {

}
