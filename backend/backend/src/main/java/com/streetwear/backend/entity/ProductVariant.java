package com.streetwear.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_variants", uniqueConstraints = { @UniqueConstraint(columnNames = {"product_id", "size", "color"})})
@Getter
@Setter
@NoArgsConstructor

public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotBlank
    @Column(nullable = false)
    private String size;

    @NotBlank
    @Column(nullable = false)
    private String color;

    @Min(0)
    @Column(nullable = false)
    private int stock;

}
