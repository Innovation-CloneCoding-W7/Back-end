//
//package com.sparta.clonetesla.entity;
//
//import com.sparta.clonetesla.controller.request.CartProductBuilder;
//import com.sparta.clonetesla.controller.request.CartProductDto;
//import lombok.*;
//import lombok.Builder;
//import org.hibernate.mapping.ToOne;
//import org.springframework.security.core.userdetails.User;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Entity
//public class Cart extends Timestamped{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long CartId;
//    @OneToOne(fetch = FetchType.EAGER) // 한명의 사용자가 한개의 카트를 가짐
//    @JoinColumn(name = "member_Id")
//    private Member member;
//
//    @Column
//    private String nickName;
//
//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    List<Product> cartProductDtos;
//
//
////    private Long id;
////    private String productName;
////    private int price;
////    private int quantity;
////    private String imageUrl;
////    private Cart(CartBuilder builder){
////    this.id = builder.id;
////    this.productName = builder.productName;
////    this.price = builder.price;
////    this.quantity = builder.quantity;
////    this.imageUrl = builder.imageUrl;
////    }
//
//}
