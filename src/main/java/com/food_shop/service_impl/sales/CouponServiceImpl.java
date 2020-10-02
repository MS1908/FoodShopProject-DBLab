package com.food_shop.service_impl.sales;

import com.food_shop.repo.sales.CouponRepo;
import com.food_shop.repo.sales.PromotionRepo;
import com.food_shop.service.sales.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponServiceImpl.class);

    @Autowired
    private CouponRepo couponRepo;

}
