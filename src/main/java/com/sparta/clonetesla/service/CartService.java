package com.sparta.clonetesla.service;

import com.sparta.clonetesla.controller.request.CartRequestDto;
import com.sparta.clonetesla.controller.response.CartResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.*;
import com.sparta.clonetesla.exception.CustomException;
import com.sparta.clonetesla.exception.ErrorCode;
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
            System.out.println("eifjeifjei");
            Long productId = cartItems.get(i).getProductId();
            int quantity = cartItems.get(i).getQuantity();
            System.out.println(productId);
            System.out.println(quantity);

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
        Optional<Product> item = itemRepository.findByProductName(requestDto.getProductName());

        if (quantity == 0) {
            throw new CustomException(ErrorCode.NOT_FOUND_QUANTITY);
        }

        Cart cart = cartRepository.findById(user.getId()).orElseThrow( // cartId와 userId는 동일하게 세팅되어 있습니다.
                () -> new CustomException(ErrorCode.NOT_FOUND_CART)
        );

        List<CartItem> cartItems = cart.getCartItems();
        //중복검사
        int cartItemId = -1;

        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getProductId() == item.get().getId()) {
                cartItemId = i;
            }
        }

        if (cartItemId != -1) {//중복이 있는 경우
            cartItems.get(cartItemId).setQuantity(quantity);
            cartItemRepository.save(cartItems.get(cartItemId));
        } else {// 중복이 없는 경우
            CartItem cartItem = new CartItem(user.getId(), item.get().getId(), quantity);
            cartItemRepository.save(cartItem);
            ResponseDto.success("add Success");
        }
    }

    // Cart Item 삭제
    @Transactional
    public void deleteItem(UserDetailsImpl userDetails,  String productName) {
        Member user = userDetails.getMember();
        Optional<Product> item = itemRepository.findByProductName(productName);
        Optional<CartItem> cartItem = cartItemRepository.findByProductId(item.get().getId());

        if(!Objects.equals(user.getId(), cartItem.get().getUserId())) throw new CustomException(ErrorCode.NOT_USER_CART);

        cartItemRepository.deleteById(cartItem.get().getCartItemId());
        ResponseDto.success("Delete Success");
    }
}

