package com.sparta.clonetesla.service;

import com.sparta.clonetesla.controller.request.ProductRequestDto;
import com.sparta.clonetesla.controller.response.CategoryResponseDto;
import com.sparta.clonetesla.controller.response.ProductResponseDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.entity.Category;
import com.sparta.clonetesla.entity.Product;
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
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @Transactional(readOnly = true)
    public ResponseDto<?> getProductByCategory(String categoryName) {
        Category category = categoryService.isPresentCategory(categoryName);
        if (category == null) {
            return ResponseDto.fail("NOT_FOUND", "This page does not exist.");
        }

        List<Product> productList = productRepository.findAllByCategory(category);
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        for (Product product : productList) {
            productResponseDtoList.add(
                    ProductResponseDto.builder()
                            .id(product.getId())
                            .productName(product.getProductName())
                            .price(product.getPrice())
                            .imageUrl(product.getImageUrl())
                            .build()
            );
        }
        return ResponseDto.success(productResponseDtoList);
    }

    @Transactional(readOnly = true)
    public Product isPresentProduct(String productName) {
        Optional<Product> optionalProduct = productRepository.findByProductName(productName);
        return optionalProduct.orElse(null);
    }

    @Transactional(readOnly = true)
    public ResponseDto<?> getProductDetail(String productName) {
        Product product = isPresentProduct(productName);
        if (null == product) {
            return ResponseDto.fail("NOT_FOUND","This page does not exist.");
        }

        return ResponseDto.success(
                ProductResponseDto.builder()
                        .id(product.getId())
                        .imageUrl(product.getImageUrl())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .maxQuantity(product.getMaxQuantity())
                        .detail(product.getDetail())
                        .composition(product.getComposition())
                        .info(product.getInfo())
                        .caution(product.getCaution())
                        .partNumber(product.getPartNumber())
                        .importedBy(product.getImportedBy())
                        .origin(product.getOrigin())
                        .applicableModels(product.getApplicableModels())
                        .releaseDate(product.getReleaseDate())
                        .size(product.getSize())
                        .build()
        );
    }

    public ResponseDto<?> postProductDetail(ProductRequestDto productRequestDto) {
        if (null == productRequestDto) {
            return ResponseDto.fail("BAD_REQUEST", "Data is none");
        }

        Product product = Product.builder()
                .id(productRequestDto.getId())
                .imageUrl(productRequestDto.getImageUrl())
                .productName(productRequestDto.getProductName())
                .category (productRequestDto.getCategory())
                .price(productRequestDto.getPrice())
                .maxQuantity(productRequestDto.getMaxQuantity())
                .detail(productRequestDto.getDetail())
                .composition(productRequestDto.getComposition())
                .info(productRequestDto.getInfo())
                .caution(productRequestDto.getCaution())
                .partNumber(productRequestDto.getPartNumber())
                .importedBy(productRequestDto.getImportedBy())
                .origin(productRequestDto.getOrigin())
                .applicableModels(productRequestDto.getApplicableModels())
                .releaseDate(productRequestDto.getReleaseDate())
                .size(productRequestDto.getSize())
                .build();
        productRepository.save(product);

        return ResponseDto.success(
                ProductResponseDto.builder()
                        .id(product.getId())
                        .imageUrl(product.getImageUrl())
                        .productName(product.getProductName())
                        .price(product.getPrice())
                        .maxQuantity(product.getMaxQuantity())
                        .detail(product.getDetail())
                        .composition(product.getComposition())
                        .info(product.getInfo())
                        .caution(product.getCaution())
                        .partNumber(product.getPartNumber())
                        .importedBy(product.getImportedBy())
                        .origin(product.getOrigin())
                        .applicableModels(product.getApplicableModels())
                        .releaseDate(product.getReleaseDate())
                        .size(product.getSize())
                        .build()
        );
    }

}