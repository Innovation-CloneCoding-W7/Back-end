//package com.sparta.clonetesla.service;
//
//import com.sparta.clonetesla.controller.request.CartRequestDto;
//import com.sparta.clonetesla.controller.response.CartResponseDto;
//import com.sparta.clonetesla.controller.response.ResponseDto;
//import com.sparta.clonetesla.entity.*;
//import com.sparta.clonetesla.repository.CartProductRepository;
//import com.sparta.clonetesla.repository.CartRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//@RequiredArgsConstructor
//@Service
//public class CartService {
//    private final CartRepository cartRepository;
//    private final CartProductRepository cartProductRepository;
//
//
//    // 상품 추가
//    @Transactional
//    public ResponseDto<Object> addItem(UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
//
//        Member member = userDetails.getMember();
//        int quantity = requestDto.getQuantity();
//
//        Cart cart = cartRepository.findByNickName(member.getNickname());
//        List<CartProduct> cartProductList = cart.getCartProductList();
//
//        Cart addCart = Cart.builder()
//                           .member(member)
//                           .quantity(quantity)
//                           .build();
//        cartRepository.save(addCart);
//
//        return ResponseDto.success("add Success");
//    }
//
//    // Cart 조회
//        public void showCart (UserDetailsImpl userDetails){
//            Member member = userDetails.getMember();
//
//            Cart cart = cartRepository.findByMember_Id(member.getId());
//            List<CartProduct> productList = cart.getCartProductList();
//            List<CartResponseDto> cartResponseDto = new ArrayList<>();
//            for(int i = 0; i < productList.size(); i++) {
//                Long id = Long.valueOf(productList.get(i).getProductName());
//                int quantity = productList.get(i).getQuantity();
//                Product product = CartRepository.findByProductName(id);
//                CartResponseDto newDto = new CartResponseDto(product, quantity);
//                cartResponseDto.add(newDto);
//            }
//                return cartResponseDto;
//            }
//
//
//        // 상품 삭제
//        public void deleteItem(UserDetailsImpl userDetails, String productName) {
//            Member member = userDetails.getMember();
//            CartProduct cartProduct = cartProductRepository.findByProductName(productName);
//            Cart cart = cartRepository.findByNickNameAndCartProduct(member,cartProduct);
//
//            cartRepository.delete(cart);
//            ResponseDto.success("Delete Success");
//        }
//}
//
