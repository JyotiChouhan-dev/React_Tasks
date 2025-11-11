package com.ecommerce_backend.ecommerce_backend.service;
import com.ecommerce_backend.ecommerce_backend.model.CartItem;
import com.ecommerce_backend.ecommerce_backend.repo.CartRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Get all items in cart
    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    // Add item to cart
    public CartItem addToCart(CartItem item) {
        return cartRepository.save(item);
    }

    // Remove item from cart
    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    // Update quantity
    public CartItem updateQuantity(Long id, int quantity) {
        CartItem item = cartRepository.findById(id).orElseThrow();
        item.setQuantity(quantity);
        return cartRepository.save(item);
    }

    // Clear entire cart
    public void clearCart() {
        cartRepository.deleteAll();
    }
}
