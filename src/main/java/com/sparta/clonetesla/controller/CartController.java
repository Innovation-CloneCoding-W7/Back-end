package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.entity.UserDetailsImpl;
//import com.sparta.clonetesla.exception.CustomException;
//import com.sparta.clonetesla.exception.ErrorCode;
import com.sparta.clonetesla.service.CartService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/cart/*")
public class CartController {
//
//    private final CartService cartService;
//
//    public CartController(CartService cartService) {
//        this.cartService = cartService;
//    }
//
//
//    // 상품 추가
//    @PostMapping("/cart/{productName}")
//    public void addItem (@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
//        cartService.addItem(userDetails, requestDto);
//    }
//
//    // Cart 조회
//    @GetMapping("/cart")
//    public List<CartResponseDto> showCart(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return cartService.showCart(userDetails);
//    }
//
//
//    // 상품 삭제
//    @DeleteMapping("/cart/{productName}")
//    public void deleteItem(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable String productName) {
//        cartService.deleteItem(userDetails, productName);
//    }
}
//    CartService cartService;
//    //회원일 경우
//    //1.장바구니 추가
//    @RequestMapping("insert.do")
//    public String insert(@ModelAttribute CartVO vo, HttpSession session){
//        String nickname = (String) session.getAttribute("nickname");
//        vo.setNickname(nickname);
//        //장바구니에 기존 상품이 있는지 검사
//        int count = cartService.countCart(vo.getName(),nickname);
//        count == 0? cartService.updateCart(vo) : cartService.insert(vo);
//        if (count == 0){
//            //없으면 insert
//            cartService.insert(vo);
//        } else {
//            //있으면 update
//            cartService.updateCart(vo);
//        }
//        return
//    }