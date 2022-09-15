package com.sparta.clonetesla.entity;

import lombok.*;
import lombok.Builder;
import javax.persistence.*;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
}
