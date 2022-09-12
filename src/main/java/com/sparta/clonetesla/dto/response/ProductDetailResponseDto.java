package com.sparta.clonetesla.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponseDto {
    private Long id;
    private String productName;
    private String category;
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


}
