package com.pragma.foodcourt.infrastructure.out.jpa.repository;

import com.pragma.foodcourt.infrastructure.out.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
