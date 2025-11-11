package com.ecommerce_backend.ecommerce_backend.repo;
import com.ecommerce_backend.ecommerce_backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {}
