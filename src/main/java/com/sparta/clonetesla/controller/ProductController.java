package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/product/{category}", method = RequestMethod.GET)
    public ResponseDto<?> getProductByCategory(@PathVariable String categoryName) {
        return productService.getProductByCategory(categoryName);
    }

    @RequestMapping(value = "/shop/product/{productName}", method = RequestMethod.GET)
    public ResponseDto<?> getProductDetail(@PathVariable String productName) {
        return productService.getProductDetail(productName);
    }



}
