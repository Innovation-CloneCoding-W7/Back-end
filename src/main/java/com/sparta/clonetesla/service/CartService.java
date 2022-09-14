package com.sparta.clonetesla.service;

import com.sparta.clonetesla.Exception.CustomException;
import com.sparta.clonetesla.Exception.ErrorCode;
import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.*;

import com.sparta.clonetesla.repository.CartItemRepository;
import com.sparta.clonetesla.repository.CartRepository;

import com.sparta.clonetesla.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository itemRepository;

    // Cart 조회
    public List<CartResponseDto> showCart(UserDetailsImpl userDetails) {
        Member user = userDetails.getMember();

        Cart cart = cartRepository.findById(user.getId()).orElseThrow( // cartId와 userId는 동일하게 세팅되어 있습니다.
                () -> new NullPointerException("카트가 존재하지 않습니다.")
        );

        List<CartItem> cartItems = cart.getCartItems();
        List<CartResponseDto> cartResponseDtos = new ArrayList<>();

        for(int i = 0; i < cartItems.size(); i++) {
            Long productId = cartItems.get(i).getProductId();
            int quantity = cartItems.get(i).getQuantity();
            Product item = itemRepository.findById(productId).orElseThrow(
                    () -> new NullPointerException("제품이 존재하지 않습니다.")
            );
            CartResponseDto newDto = new CartResponseDto(item, quantity);
            cartResponseDtos.add(newDto);
        }
        return cartResponseDtos;
    }

    // Cart Item 추가
    @Transactional
    public void saveItem(UserDetailsImpl userDetails, @RequestBody CartRequestDto requestDto) {
        Member user = userDetails.getMember();
        int quantity = requestDto.getQuantity();
        Optional<Product> item = itemRepository.findById(requestDto.getItemId());

        if (quantity == 0) {
            throw new CustomException(ErrorCode.NOT_FOUND_QUANTITY);
        }

//        Cart cart = cartRepository.findById(user.getId()).orElseThrow( // cartId와 userId는 동일하게 세팅되어 있습니다.
//                () -> new CustomException(ErrorCode.NOT_FOUND_CART)
//        );
//
//        List<CartItem> cartItems = cart.getCartItems();
////중복검사
//        int cartItemId = -1;
//
//        for(int i = 0; i < cartItems.size(); i++) {
//            if(cartItems.get(i).getItemId() == item.get().getId() ) {
//                cartItemId = i;
//            }
//        }
//
//        if(cartItemId != -1) {
//            cartItems.get(cartItemId).setQuantity(cartItems.get(cartItemId).getQuantity() + quantity);
//            cartItemRepository.save(cartItems.get(cartItemId));
//        } else {
            CartItem cartItem = new CartItem(user.getId(), item.get().getProductId(), quantity);
            cartItemRepository.save(cartItem);
        ResponseDto.success("add Success");
    }

    // Cart Item 삭제
    @Transactional
    public void deleteItem(UserDetailsImpl userDetails,  Long cartItemId) {
        Member user = userDetails.getMember();
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_CARTITEM)
        );

        if(!Objects.equals(user.getId(), cartItem.getUserId())) throw new CustomException(ErrorCode.NOT_USER_CART);

        cartItemRepository.deleteById(cartItemId);
        ResponseDto.success("Delete Success");
    }





//    private final CartRepository cartRepository;
//
//    private  final CartProductDto cartProductDto;
//
//
//    // 상품 추가
//    @Transactional
//    public void addItem(UserDetailsImpl userDetails, CartRequestDto requestDto) {
//
//        Member member = userDetails.getMember();
//        int quantity = requestDto.getQuantity();
//
//        Cart cart = new Cart(member,quantity);
//        cartRepository.save(cart);
//        ResponseDto.success("add Success");
//        }
////
////    Cart addCart = Cart.builder()
////            .member(member)
////            .quantity(quantity)
////            .build();
////        cartRepository.save(addCart);
////
//
//
//    // Cart 조회
//        public CartResponseDto showCart (UserDetailsImpl userDetails){
//            Member member = userDetails.getMember();
//
//            Cart cart = cartRepository.findByMember_Id(member.getId());
//            List<Cart> productList = (List<Cart>) cart.getCartProductDto();
//            List<CartResponseDto> CartResponseDtos = new ArrayList<>();
//            for(int i = 0; i < productList.size(); i++) {
//                Long id = productList.get(i).getCartId();
//                Product quantity = productList.get(i).getCartProductDto();
////                Product product = CartRepository.findByProductName(id);
//                CartResponseDto newDto = new CartResponseDto(id, quantity);
//                CartResponseDtos.add(newDto);
//            } return (CartResponseDto) CartResponseDtos;
//
//            }
//
//
//        // 상품 삭제
//        public void deleteItem(UserDetailsImpl userDetails, String productName) {
//            Member member = userDetails.getMember();
//
//            List<Cart> carts = cartRepository.findByMember(member);
//            Product product = cartProductDto.findByProductName(productName);
//            cartRepository.deleteAll(carts,product);
//
//            ResponseDto.success("sDelete Success");
////            CartProduct cartProduct = cartProductRepository.findByProductName(productName);
////            Cart cart = cartRepository.findByNickNameAndCartProduct(member,cartProduct);
////            cartRepository.delete(cart);
////            ResponseDto.success("Delete Success");
//        }
}

