package com.sparta.clonetesla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int maxQuantity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    

//    @JoinColumn(name = "cart")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Cart cart;


}

