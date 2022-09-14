package com.sparta.clonetesla.controller.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
    private Long itemId;
    private int quantity;

    //    private String productName;
//    private int quantity;

}
