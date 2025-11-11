package com.ecommerce_backend.ecommerce_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private String title;
    private double price;
    private int quantity;
    private String image;
}
