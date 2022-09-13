//package com.sparta.clonetesla.service;
//
//import com.sparta.clonetesla.controller.request.CartRequestDto;
//import com.sparta.clonetesla.controller.response.CartResponseDto;
//import com.sparta.clonetesla.controller.response.ResponseDto;
//import com.sparta.clonetesla.entity.*;
//import com.sparta.clonetesla.repository.CartProductRepository;
//import com.sparta.clonetesla.repository.CartRepository;
//import com.sparta.clonetesla.repository.MemberRepository;
//import com.sparta.clonetesla.repository.ProductRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class CartService {
//    private final CartRepository cartRepository;
//    private final CartProductRepository cartProductRepository;
//    private final MemberRepository memberRepository;
//    private final ProductRepository productRepository;
//
//
//    // 상품 추가
//    @Transactional
//    public Long addItem(UserDetailsImpl userDetails, CartRequestDto requestDto) {
//
//        Member member = userDetails.getMember();
//        int quantity = requestDto.getQuantity();
//
//        Cart cart = cartRepository.findByNickName(member.getNickname());
//        if (cart == null) {
//            cart = cart.createCart(member);
//            cartRepository.save(cart);
//        }
//
//        Product product = productRepository.findByProductName(requestDto.getProductName());
//        CartProduct cartProduct = cartProductRepository.findByCartProductIdAndId(cart.getCartId(), product.get().getId());
//
//        if (cartProduct == null) {
//            cartProduct = CartProduct.createCartProduct(cart, cartProduct, requestDto.getQuantity());
//            cartProductRepository.save(cartProduct);
//        } else {
//            cartProduct.addCount(requestDto.getQuantity());
//        }
//        return cartProduct.getCartProductId();
//
//    }
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
