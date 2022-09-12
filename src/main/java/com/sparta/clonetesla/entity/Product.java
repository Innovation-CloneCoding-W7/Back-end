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
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int maxQuantity;

    @Column(nullable = false)
    private String detail;

//    @OneToMany(mappedBy = "")
//    private List<Composition> composition;

    @Column
    private String composition;

    @Column(nullable = false)
    private String info;

    @Column(nullable = false)
    private String caution;

    @Column(nullable = false)
    private String partNumber;

    @Column(nullable = false)
    private String importedBy;

    @Column(nullable = false)
    private String origin;

//    @OneToMany
//    private List<applicableModels> applicableModels;

    @Column
    private String applicableModels;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String size;

}