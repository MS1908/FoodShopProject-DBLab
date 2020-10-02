package com.food_shop.service.sales;

import com.food_shop.entities.sales.Promotion;
import com.food_shop.payload.sales.PromotionForm;

import java.util.Optional;

public interface PromotionService {

    Optional<Promotion> findValidByCustomerAndCouponCode(String username, String couponCode);

    Optional<Promotion> findByCustomerAndCouponCode(String username, String couponCode);

    boolean submit(PromotionForm promotionForm);
}
