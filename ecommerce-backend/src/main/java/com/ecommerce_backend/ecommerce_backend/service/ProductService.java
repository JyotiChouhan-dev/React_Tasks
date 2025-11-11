package com.ecommerce_backend.ecommerce_backend.service;

import com.ecommerce_backend.ecommerce_backend.model.Product;
import com.ecommerce_backend.ecommerce_backend.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Fetch all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Fetch product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Fetch products by category
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    // Save or update product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
