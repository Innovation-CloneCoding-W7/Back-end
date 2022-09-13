package com.sparta.clonetesla.controller.request;

import com.sparta.clonetesla.controller.response.CategoryResponseDto;
import com.sparta.clonetesla.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private Long id;
    private String imageUrl;
    private String productName;
    private Category category;
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
