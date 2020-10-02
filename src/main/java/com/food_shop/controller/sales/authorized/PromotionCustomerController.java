package com.food_shop.controller.sales.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.sales.PromotionService;
import com.food_shop.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/customer/promotion")
public class PromotionCustomerController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/check-valid")
    public ResponseEntity<JsonResult> findByCustomerAndCouponCode(@RequestParam("cus-uname") String username,
                                                                  @RequestParam("cp-code") String couponCode) {
        // validate client's username and username in security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
                String currentUsername = authentication.getName();
                if (!currentUsername.equals(username)) return JsonResult.badRequest("Get the fuck out boo!");
        }

        return promotionService.findByCustomerAndCouponCode(username, couponCode)
                .map(p -> {
                    if (DateTimeUtils.asLocalDateTime(p.getCoupon().getExpiredDate()).isBefore(LocalDateTime.now())) {
                        return JsonResult.notFound("Coupon Code has expired");
                    } else return JsonResult.found(p.getCoupon());
                })
                .orElse(JsonResult.notFound("Coupon Code"));

    }

}
