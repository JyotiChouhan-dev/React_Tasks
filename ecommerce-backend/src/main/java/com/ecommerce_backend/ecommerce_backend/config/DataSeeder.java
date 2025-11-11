//package com.ecommerce_backend.ecommerce_backend.config;
//
//import com.ecommerce_backend.ecommerce_backend.model.OrderEntity;
//import com.ecommerce_backend.ecommerce_backend.model.PromoCode;
//import com.ecommerce_backend.ecommerce_backend.repo.OrderRepository;
//import com.ecommerce_backend.ecommerce_backend.repo.PromoCodeRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    private final PromoCodeRepository promoCodeRepository;
//    private final OrderRepository orderRepository;
//
//    public DataSeeder(PromoCodeRepository promoCodeRepository, OrderRepository orderRepository) {
//        this.promoCodeRepository = promoCodeRepository;
//        this.orderRepository = orderRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        seedPromoCodes();
//        seedOrders();
//    }
//
//    private void seedPromoCodes() {
//        if (promoCodeRepository.count() == 0) {
//            PromoCode promo1 = new PromoCode(null, "WELCOME10", 10, LocalDate.now().plusDays(30));
//            PromoCode promo2 = new PromoCode(null, "DISCOUNT20", 20, LocalDate.now().plusDays(15));
//            PromoCode promo3 = new PromoCode(null, "FESTIVE50", 50, LocalDate.now().plusDays(60));
//
//            promoCodeRepository.save(promo1);
//            promoCodeRepository.save(promo2);
//            promoCodeRepository.save(promo3);
//        }
//    }
//
//    private void seedOrders() {
//        if (orderRepository.count() == 0) {
//            PromoCode promo1 = promoCodeRepository.findByCode("WELCOME10").orElse(null);
//            PromoCode promo2 = promoCodeRepository.findByCode("DISCOUNT20").orElse(null);
//
//            OrderEntity order1 = new OrderEntity();
//            order1.setCustomerName("Alice");
//            order1.setCustomerEmail("alice@example.com");
//            order1.setPromoCode(promo1);
//            order1.setTotalAmount(500);
//            order1.setStatus("PENDING");
//            order1.setCreatedAt(LocalDateTime.now());
//            order1.setDeliveryTime(LocalDateTime.now().plusHours(6));
//
//            OrderEntity order2 = new OrderEntity();
//            order2.setCustomerName("Bob");
//            order2.setCustomerEmail("bob@example.com");
//            order2.setPromoCode(promo2);
//            order2.setTotalAmount(1200);
//            order2.setStatus("PENDING");
//            order2.setCreatedAt(LocalDateTime.now());
//            order2.setDeliveryTime(LocalDateTime.now().plusHours(6));
//
//            orderRepository.save(order1);
//            orderRepository.save(order2);
//        }
//    }
//}
