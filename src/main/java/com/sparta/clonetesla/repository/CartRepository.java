package com.sparta.clonetesla.repository;

import com.sparta.clonetesla.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

//       static void deleteByProductName(String productName){
//       }
//       Cart findByNickName(String nickname);
}