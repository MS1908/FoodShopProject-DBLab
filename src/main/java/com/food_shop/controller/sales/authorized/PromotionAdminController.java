package com.food_shop.controller.sales.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.payload.sales.PromotionForm;
import com.food_shop.service.app_user.AppUserService;
import com.food_shop.service.sales.OrdersService;
import com.food_shop.service.sales.PromotionService;
import com.food_shop.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/promotion")
public class PromotionAdminController {

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/apply-list")
    public ResponseEntity<JsonResult> findApplyList() {
        return Optional.ofNullable(ordersService.findCustomerSpense())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Apply List not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @PostMapping("/submit")
    public ResponseEntity<JsonResult> submit(@RequestBody PromotionForm promotionForm) {
        if (promotionService.submit(promotionForm)) {
            return JsonResult.uploaded("Promotion Updated");
        }
        return JsonResult.serverError("Internal Server Error");
    }

}
