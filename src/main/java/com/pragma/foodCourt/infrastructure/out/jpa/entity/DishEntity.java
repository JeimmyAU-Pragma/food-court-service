package com.pragma.foodcourt.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dishes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Long price;
    private String description;
    private String urlImage;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false,
            foreignKey = @ForeignKey(name = "fk_dish_category"))
    private CategoryEntity category;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false,
            foreignKey = @ForeignKey(name = "fk_dish_restaurant"))
    private RestaurantEntity restaurant;

}
