package com.ecommerce_backend.ecommerce_backend.repo;

import com.ecommerce_backend.ecommerce_backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByUserId(String userId);
}