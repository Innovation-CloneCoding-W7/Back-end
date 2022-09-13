package com.sparta.clonetesla.service;

import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.*;
import com.sparta.clonetesla.repository.CartProductRepository;
import com.sparta.clonetesla.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CartService {
//    private final CartRepository cartRepository;
//    private final CartProductRepository cartProductRepository;
//
//
//    // 상품 추가
//    @Transactional
//    public ResponseDto<Object> addItem(UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
//        Member member = userDetails.getMember();
//        int quantity = requestDto.getQuantity();
//
//        Cart cart = cartRepository.findByNickName(member.getNickname());
//        List<CartProduct> cartProductList = cart.getCartProductList();
//
//
//        int cartProductId = 1;
//        for (int i = 0; i < cartProductList.size();i++){
//
//        }
//
//
//        if(cart == null) {
//            return ResponseDto.fail("CART_EMPTY", "장바구니가 비어있습니다.");
//        }
//
//
//
//        Cart addCart = new Cart(member, quantity, productList);
//        cartRepository.save(addCart);
//        return ResponseDto.success("add Success");
//    }
//
//    // Cart 조회
//        public List<CartResponseDto> showCart (UserDetailsImpl userDetails){
//            Member member = userDetails.getMember();
//
//            CartProduct cartProduct = CartProductRepository.findBycartProductId(cartProductId);
//            if (cart == null) {
//                return ResponseDto.fail("NOT_FOUND_CART", "장바구니가 비었습니다.");
//            }
//            List<Product> productList1 = cart.getProductList();
//            List<CartResponseDto> cartResponseDtos = new ArrayList<>();
//            for(int i = 0; i < productList1.size(); i++) {
//                Long productId = productList1.get(i).getProductId();
//                int quantity = productList1.get(i).getQuantity();
//                Product product = CartRepository.findBycartProductId(ProductName).orElseThrow(
//                        () -> new NullPointerException("제품이 존재하지 않습니다.")
//                );
//                CartResponseDto newDto = new CartResponseDto(product, quantity);
//                cartResponseDtos.add(newDto);
//            }
//                return cartResponseDtos;
//            }
//
//
//        // 상품 삭제
//        public void deleteItem(UserDetailsImpl userDetails, String productName) {
//            Member member = userDetails.getMember();
//
//            cartRepository.deleteByProductName(String productName);
//            ResponseDto.success("Delete Success");
//        }

}

