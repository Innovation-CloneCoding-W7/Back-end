//package com.sparta.clonetesla.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.*;
//
//@Entity
//@NoArgsConstructor
//@Getter
//@Setter
//public class CartProduct {
//    @javax.persistence.Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(nullable = false)
//    private String nickName;
//
//    @Column(nullable = false)
//    private String productName;
//
//    @Column(nullable = false)
//    private int price;
//
//    @Column(nullable = false)
//    private int quantity;
//
//    @Column(nullable = false)
//    private String imageUrl;
//
//    public CartProduct(String nickName,String productName,int price,int quantity,String imageUrl){
//        this.nickName = nickName;
//        this.productName = productName;
//        this.price = price;
//        this.quantity = quantity;
//        this.imageUrl = imageUrl;
//    }
//}
