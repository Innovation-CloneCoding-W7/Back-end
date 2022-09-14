package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.request.ProductRequestDto;
import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/product/category/{categoryName}", method = RequestMethod.GET)
    public ResponseDto<?> getProductByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @RequestMapping(value = "/product/{productName}", method = RequestMethod.GET)
    public ResponseDto<?> getProductDetail(@PathVariable String productName) {
        return productService.getProductDetail(productName);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseDto<?> postProductDetail(@RequestBody ProductRequestDto ProductRequestDto) {
        return productService.postProductDetail(ProductRequestDto);
    }

}
