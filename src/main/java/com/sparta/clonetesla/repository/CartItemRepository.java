package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.CartItem;

import com.sparta.clonetesla.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long > {

//    Optional<CartItem> findByProduct(Product proudct);
}
