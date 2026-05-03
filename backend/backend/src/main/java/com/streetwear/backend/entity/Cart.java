package com.streetwear.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Join;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_cedula")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();




}
