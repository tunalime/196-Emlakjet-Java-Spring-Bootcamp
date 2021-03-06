package com.emlakjet.crudapp.repository;

import com.emlakjet.crudapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByName(String name);
}
