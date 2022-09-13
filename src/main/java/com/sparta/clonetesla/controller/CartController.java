package com.sparta.clonetesla.controller;


import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.entity.UserDetailsImpl;
//import com.sparta.clonetesla.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CartController {

//    private final CartService cartService;


    // 상품 추가
    @PostMapping("/cart/{productName}")
    public void addItem (@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
//        cartService.addItem(userDetails, requestDto);
    }

    // Cart 조회
    @GetMapping("/cart")
    public void showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {

//        cartService.showCart(userDetails);
    }


    // 상품 삭제
    @DeleteMapping("/cart/{productName}")
    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String productName) {
//        cartService.deleteItem(userDetails, productName);
    }
}
