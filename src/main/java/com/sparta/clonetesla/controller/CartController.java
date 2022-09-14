package com.sparta.clonetesla.controller;


import com.sparta.clonetesla.Exception.CustomException;
import com.sparta.clonetesla.Exception.ErrorCode;

import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.Member;
import com.sparta.clonetesla.entity.UserDetailsImpl;
import com.sparta.clonetesla.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;


    // 상품 추가
    @PostMapping("/cart/add")
    public void saveItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        cartService.saveItem(userDetails, requestDto);
//    public void addItem (@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
//         cartService.addItem(userDetails, requestDto);
    }

    // Cart 조회
    @GetMapping("/cart")
    public List<CartResponseDto> showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        return cartService.showCart(userDetails);

//    public CartResponseDto showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return cartService.showCart(userDetails);
    }


    // 상품 삭제, @PathVariable String productName으로 변경
    @DeleteMapping("/cart/{cartItemId}/delete")
    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable  Long cartItemId) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        cartService.deleteItem(userDetails, cartItemId);
    }
//    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String productName) {
//        cartService.deleteItem(userDetails, productName);
    }

