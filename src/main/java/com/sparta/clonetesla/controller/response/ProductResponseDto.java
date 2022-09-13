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
    private List<CategoryResponseDto> category;
    private int price;
    private int maxQuantity;
    private String detail;
    private String composition;
    private String info;
    private String caution;
    private String partNumber;
    private String importedBy;
    private String origin;
    private String applicableModels;
    private String releaseDate;
    private String size;
}
