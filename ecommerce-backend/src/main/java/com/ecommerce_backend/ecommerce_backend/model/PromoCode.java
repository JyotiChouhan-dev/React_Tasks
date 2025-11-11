package com.ecommerce_backend.ecommerce_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private double discountPercentage; // e.g., 10.0 for 10%
    private LocalDateTime expirationDate;
    private boolean valid = true;
}

