package com.sparta.clonetesla.repository;


import com.sparta.clonetesla.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findAllByCategory (String categoryName);

}