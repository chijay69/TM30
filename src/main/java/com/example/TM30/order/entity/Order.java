package com.example.TM30.order.entity;

import com.example.TM30.product.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Long productId;
}
