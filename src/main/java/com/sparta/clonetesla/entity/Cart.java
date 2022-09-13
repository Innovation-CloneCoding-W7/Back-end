package com.sparta.clonetesla.entity;

import lombok.*;
import lombok.Builder;
import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Cart extends Timestamped{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CartId;

    @OneToOne(fetch = FetchType.EAGER) // 한명의 사용자가 한개의 카트를 가짐
    @JoinColumn(name = "member_Id")
    private Member member;

    @Column
    private String nickName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    Product cartProductDto;

    public static Cart createCart (Member member) {
        Cart cart = new Cart();
        cart.member =member();
        return cart;
    }

    private static Member member() {
        return null;
    }


//    private Long id;
//    private String productName;
//    private int price;
//    private int quantity;
//    private String imageUrl;
//    private Cart(CartBuilder builder){
//    this.id = builder.id;
//    this.productName = builder.productName;
//    this.price = builder.price;
//    this.quantity = builder.quantity;
//    this.imageUrl = builder.imageUrl;
//    }

}
