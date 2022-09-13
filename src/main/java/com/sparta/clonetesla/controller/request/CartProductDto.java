package com.sparta.clonetesla.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartProductDto {
    private Long id;

    private String productName;

    private int price;

    private int quantity;

    private String imageUrl;


}
