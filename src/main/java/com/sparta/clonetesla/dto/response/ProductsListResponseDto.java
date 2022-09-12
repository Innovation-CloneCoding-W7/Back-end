package com.sparta.clonetesla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsListResponseDto {
    private String name;
    private String category;
    private int price;
    private String imageUrl;
}
