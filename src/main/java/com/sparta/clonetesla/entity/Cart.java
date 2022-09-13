package com.sparta.clonetesla.entity;

import lombok.*;
import org.hibernate.mapping.ToOne;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CartId;

    @OneToOne(fetch = FetchType.EAGER) // 한명의 사용자가 한개의 카트를 가짐
    @JoinColumn(name = "member_Id")
    private Member member;

    @Column
    @OneToMany(fetch = FetchType.LAZY) // 카트에 여러가지 상품이 들어감
    private List<CartProduct> cartProductList;

}