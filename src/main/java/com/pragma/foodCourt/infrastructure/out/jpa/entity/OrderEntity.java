package com.pragma.foodcourt.infrastructure.out.jpa.entity;


import jakarta.persistence.*;

public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Long idClient;

// ajustar a entidades
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false,
            foreignKey = @ForeignKey(name = "fk_dish_category"))
    private OrderDishesEntity orderDishes;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false,
            foreignKey = @ForeignKey(name = "fk_dish_restaurant"))
    private RestaurantEntity restaurant;
}
