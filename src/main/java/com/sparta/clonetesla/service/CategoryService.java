package com.sparta.clonetesla.service;

import com.sparta.clonetesla.controller.response.CategoryResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.Category;
import com.sparta.clonetesla.repository.CartRepository;
import com.sparta.clonetesla.repository.CategoryRepository;
import com.sparta.clonetesla.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Transactional(readOnly = true)
    public Category isPresentCategory(String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findAllByCategoryName(categoryName);
        return optionalCategory.orElse(null);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getCategories() {

        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();

        for (Category category : categoryList) {
            categoryResponseDtoList.add(
                    CategoryResponseDto.builder()
                            .id(category.getId())
                            .categoryName(category.getCategoryName())
                            .build()
            );
        }
        return ResponseDto.success(categoryResponseDtoList);
    }

}
