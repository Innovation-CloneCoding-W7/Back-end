package com.sparta.clonetesla.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
    private String productName;
    private int quantity;

}
