//package com.sparta.clonetesla.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
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
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long CartProductId;
//    private String nickName;
//    private String productName;
//    private int price;
//    private int quantity;
//    private String imageUrl;
//
//    public static CartProduct createCartProduct(String nickName,String productName,int price,int quantity,String imageUrl){
//       CartProduct cartProduct = new CartProduct();
//       cartProduct.setProductName(productName);
//       cartProduct.setPrice(price);
//       cartProduct.setNickName(nickName);
//       cartProduct.setQuantity(quantity);
//       cartProduct.setImageUrl(imageUrl);
//
//       return cartProduct;
//    }
//
//    public static CartProduct createCartProduct(Cart cart, CartProduct cartProduct, int quantity) {
//    }
//
//    public void addCount(int quantity) {
//    }
//}
