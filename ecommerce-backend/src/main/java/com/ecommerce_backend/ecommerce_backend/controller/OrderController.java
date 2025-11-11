package com.ecommerce_backend.ecommerce_backend.controller;

import com.ecommerce_backend.ecommerce_backend.model.OrderEntity;
import com.ecommerce_backend.ecommerce_backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/place")
    public OrderEntity placeOrder(@RequestBody OrderEntity order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public Optional<OrderEntity> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order with ID " + id + " deleted successfully!";
    }
}
