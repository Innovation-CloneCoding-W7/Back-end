package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Category;
import com.sparta.clonetesla.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
    Optional<Product> findByProductName(String productName);

}