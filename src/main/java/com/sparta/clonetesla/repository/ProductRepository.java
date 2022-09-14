package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByCategory(String category);
    Optional<Product> findByProductName(String productName);
//    List<Product> findAllByCategory(Category category);

}