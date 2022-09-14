package com.sparta.clonetesla.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String imageUrl;
    private String productName;
    private String category;
    private int price;
    private int maxQuantity;
    private String content;

}
