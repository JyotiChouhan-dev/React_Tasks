package com.ecommerce_backend.ecommerce_backend.controller;

import com.ecommerce_backend.ecommerce_backend.model.CartItem;
import com.ecommerce_backend.ecommerce_backend.repo.CartRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartRepository cartRepository;
    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartRepository.findAll();
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartRepository.deleteById(id);
    }
}
