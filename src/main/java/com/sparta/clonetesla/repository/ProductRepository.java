package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Category;
import com.sparta.clonetesla.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductName(String productName);
    List<Product> findAllByCategory(Category category);
}
