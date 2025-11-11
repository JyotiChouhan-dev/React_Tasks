package com.ecommerce_backend.ecommerce_backend.controller;

import com.ecommerce_backend.ecommerce_backend.model.PromoCode;
import com.ecommerce_backend.ecommerce_backend.repo.PromoCodeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/promo")
@CrossOrigin(origins = "http://localhost:3000")
public class PromoCodeController {

    private final PromoCodeRepository promoCodeRepository;

    public PromoCodeController(PromoCodeRepository promoCodeRepository) {
        this.promoCodeRepository = promoCodeRepository;
    }

    @GetMapping("/validate/{code}")
    public String validatePromo(@PathVariable String code) {
        Optional<PromoCode> promoOpt = promoCodeRepository.findByCode(code);
        if (promoOpt.isEmpty()) {
            return "Invalid promo code";
        }

        PromoCode promo = promoOpt.get();
        if (promo.getExpiryDate().isBefore(LocalDate.now())) {
            return "Promo code expired";
        }

        return "Valid promo code: " + promo.getDiscountPercentage() + "% off";
    }
}
