package com.example.TM30.product.entity;

import com.example.TM30.order.entity.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DialectOverride;

@Getter
@Setter
@Entity
@Table(name = "products")
@DialectOverride.Version(major = 0, minor = 1)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

}
