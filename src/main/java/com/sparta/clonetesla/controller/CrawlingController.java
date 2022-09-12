package com.sparta.clonetesla.controller;

import com.sparta.clonetesla.controller.response.ResponseDto;
import com.sparta.clonetesla.service.CrawlingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CrawlingController {

    private final CrawlingService crawlingService;

    @GetMapping("/crawling")
    public ResponseDto<?> insert(){
        return crawlingService.insert();
    }
}
