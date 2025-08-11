package com.pragma.foodcourt.domain.model;

public class CategoryModel {
    Long id;
    String name;
    String description;

    public CategoryModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public CategoryModel(Long id) {
        this.id = id;
    }
    public CategoryModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
