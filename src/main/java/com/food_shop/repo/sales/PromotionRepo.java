package com.food_shop.repo.sales;

import com.food_shop.entities.sales.Coupon;
import com.food_shop.entities.sales.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Integer> {
    @Query(value = "select p from Promotion p " +
            "where " +
                "p.customer.username = ?1 " +
                "and p.coupon.couponCode = ?2 " +
                "and p.used = false " +
                "and p.coupon.expiredDate > ?#{new java.util.Date()}")
    Optional<Promotion> findValidByCustomerAndCouponCode(String username, String couponCode);

    @Query(value = "select p from Promotion p " +
            "where " +
                "p.customer.username = ?1 " +
                "and p.coupon.couponCode = ?2 " +
                "and p.used = false ")
    Optional<Promotion> findByCustomerAndCouponCode(String username, String couponCode);

    @Transactional
    @Modifying
    @Query(value = "update Promotion p set p.used = true where p.customer.idUser = ?1 and p.coupon.couponCode = ?2 ")
    int updatePromotionUse(Integer idUser, String couponCode);

}

