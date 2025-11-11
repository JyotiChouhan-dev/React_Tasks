package com.ecommerce_backend.ecommerce_backend.service;

import com.ecommerce_backend.ecommerce_backend.model.OrderEntity;
import com.ecommerce_backend.ecommerce_backend.model.PromoCode;
import com.ecommerce_backend.ecommerce_backend.repo.OrderRepository;
import com.ecommerce_backend.ecommerce_backend.repo.PromoCodeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PromoCodeRepository promoCodeRepository;

    public OrderService(OrderRepository orderRepository, PromoCodeRepository promoCodeRepository) {
        this.orderRepository = orderRepository;
        this.promoCodeRepository = promoCodeRepository;
    }

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderEntity placeOrder(OrderEntity order) {
        order.setStatus("PENDING");
        order.setCreatedAt(LocalDateTime.now());
        order.setDeliveryTime(LocalDateTime.now().plusHours(6));

        double totalAmount = order.getTotalAmount();
        if (order.getPromoCode() != null) {
            String code = order.getPromoCode().getCode();
            if (code != null && !code.isEmpty()) {
                Optional<PromoCode> promoOpt = promoCodeRepository.findByCode(code);
                if (promoOpt.isPresent()) {
                    PromoCode promo = promoOpt.get();
                    if (promo.getExpiryDate().isAfter(LocalDate.now())) {
                        double discount = totalAmount * promo.getDiscountPercentage() / 100;
                        totalAmount -= discount;
                    }
                }
            }
        }

        order.setTotalAmount(totalAmount);
        return orderRepository.save(order);
    }

    @Scheduled(fixedRate = 60000)
    public void updateDeliveredOrders() {
        List<OrderEntity> allOrders = orderRepository.findAll();
        for (OrderEntity order : allOrders) {
            if ("PENDING".equalsIgnoreCase(order.getStatus())
                    && order.getDeliveryTime() != null
                    && LocalDateTime.now().isAfter(order.getDeliveryTime())) {
                order.setStatus("DELIVERED");
                orderRepository.save(order);
            }
        }
    }
}
