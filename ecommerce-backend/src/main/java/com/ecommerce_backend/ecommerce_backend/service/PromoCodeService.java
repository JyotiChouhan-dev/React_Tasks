package com.ecommerce_backend.ecommerce_backend.service;

import com.ecommerce_backend.ecommerce_backend.model.PromoCode;
import com.ecommerce_backend.ecommerce_backend.repo.PromoCodeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;

    public PromoCodeService(PromoCodeRepository promoCodeRepository) {
        this.promoCodeRepository = promoCodeRepository;
    }

    public Optional<PromoCode> validatePromoCode(String code) {
        Optional<PromoCode> promo = promoCodeRepository.findByCode(code);
        if (promo.isPresent() && !promo.get().getExpiryDate().isBefore(LocalDate.now())) {
            return promo;
        }
        return Optional.empty();
    }
}
