package com.food_shop.service_impl.sales;

import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.sales.Coupon;
import com.food_shop.entities.sales.Promotion;
import com.food_shop.entities.sales.PromotionId;
import com.food_shop.entities.sales.Sales;
import com.food_shop.payload.sales.PromotionForm;
import com.food_shop.repo.sales.CouponRepo;
import com.food_shop.repo.sales.PromotionRepo;
import com.food_shop.repo.sales.SalesRepo;
import com.food_shop.service.app_user.AppUserService;
import com.food_shop.service.others.SendMailService;
import com.food_shop.service.sales.PromotionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);

    @Autowired
    private PromotionRepo promotionRepo;

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private CouponRepo couponRepo;

    @Autowired
    private SendMailService sendMailService;

    @Override
    public Optional<Promotion> findValidByCustomerAndCouponCode(String username, String couponCode) {
        try {
            return promotionRepo.findValidByCustomerAndCouponCode(username, couponCode);
        } catch (Exception ex) {
            LOGGER.error("findValidByCustomerAndCouponCode error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Promotion> findByCustomerAndCouponCode(String username, String couponCode) {
        try {
            return promotionRepo.findByCustomerAndCouponCode(username, couponCode);
        } catch (Exception ex) {
            LOGGER.error("findByCustomerAndCouponCode error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean submit(PromotionForm pf) {
        try {
            Coupon newCp = Coupon.builder()
                    .couponCode(pf.getCouponCode())
                    .discount(pf.getDiscount())
                    .expiredDate(pf.getExpiredDate())
                    .build();
            return Optional.ofNullable(couponRepo.save(newCp))
                    .map(newCoupon -> {
                        for (String cusEmail : pf.getReceivers()) {
                            AppUser user = appUserService.findByUsername(cusEmail).orElse(null);
                            if (user != null) {
                                Promotion newPromo = Promotion.builder()
                                        .coupon(newCoupon).customer(user).used(false)
                                        .promotionId(new PromotionId(newCoupon.getCouponCode(), user.getIdUser()))
                                        .build();
                                if (promotionRepo.save(newPromo) != null) {
                                    String content = getContent(cusEmail, newCoupon.getCouponCode(), newCoupon.getDiscount());
                                    System.out.println(content);
                                    if (sendMailService.sendHtmlMail(user.getEmail(), "[COUPON] YummySleeping", content)) {
                                        System.out.println("Coupon sent to " + user.getEmail() +".");
                                    }
                                }
                            }
                        }
                        return true;
                    }).orElse(false);
        } catch (Exception ex) {
            LOGGER.error("uploadPromotion error", ex);
            ex.printStackTrace();
            return false;
        }
    }

    private static String getContent(String cusEmail, String couponCode, Integer discount) {
        return "<div>CONGRATULATIONS "+ cusEmail +"! You are given a lucky coupon <b>" + couponCode + "</b> Discount " + discount + "%" +"</div>";
    }
}
