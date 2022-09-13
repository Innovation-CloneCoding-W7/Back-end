package com.sparta.clonetesla.controller.response;

import com.sparta.clonetesla.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDto {
    private Long id;

    private String nickname;

    private String name;    //상품명

    private int price;  //상품가격

    private int quantity; //상품수량

    private String imageUrl;  //이미지

    public CartResponseDto(Product product, int quantity) {
        this.name = product.getProductName();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.quantity = quantity;
    }
}
