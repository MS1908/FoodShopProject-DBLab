package com.food_shop.repo.sales;

import com.food_shop.entities.sales.Coupon;
import com.food_shop.entities.sales.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {

}
