package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.entity.UserDetailsImpl;
import com.sparta.clonetesla.exception.CustomException;
import com.sparta.clonetesla.exception.ErrorCode;
import com.sparta.clonetesla.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    // 상품 추가
    @PostMapping("/cart")
    public void saveItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        cartService.saveItem(userDetails, requestDto);
    }

    // Cart 조회
    @GetMapping("/cart")
    public List<CartResponseDto> showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        return cartService.showCart(userDetails);
    }


    // 상품 삭제, @PathVariable String productName으로 변경
    @DeleteMapping("/cart")
    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam (value = "name") String productName) {
        if(userDetails == null){
            throw new CustomException(ErrorCode.UNAUTHORIZED);
        }
        cartService.deleteItem(userDetails, productName);
    }
}

