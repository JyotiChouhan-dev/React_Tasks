//package com.ecommerce_backend.ecommerce_backend.service;
//import com.ecommerce_backend.ecommerce_backend.model.Order;
//import com.ecommerce_backend.ecommerce_backend.repo.OrderRepository;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Component
//public class OrderScheduler {
//    private final OrderRepository orderRepository;
//
//    public OrderScheduler(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }
//
////    @Scheduled(fixedRate = 60 * 60 * 1000) // every 1 hour
//@Scheduled(fixedRate = 120000)
//    public void autoDeliverOrders() {
//        List<Order> pendingOrders = orderRepository.findByStatus("PENDING");
//        for (Order order : pendingOrders) {
//            if (order.getCreatedAt().plusHours(6).isBefore(LocalDateTime.now())) {
//                order.setStatus("DELIVERED");
//                orderRepository.save(order);
//            }
//        }
//    }
//}
