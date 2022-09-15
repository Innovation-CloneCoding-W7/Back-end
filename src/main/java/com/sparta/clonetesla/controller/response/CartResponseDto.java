package com.sparta.clonetesla.controller.response;

import com.sparta.clonetesla.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
//    private Long id;
//    private String nickname;
    private String productName;    //상품명
    private int price;  //상품가격
    private int quantity; //상품수량
    private String imageUrl;  //이미지
    public CartResponseDto(Product product, int quantity) {
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.quantity = quantity;
    }
}