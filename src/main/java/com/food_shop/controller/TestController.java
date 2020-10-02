package com.food_shop.controller;

import com.food_shop.entities.json.JsonResult;
import com.food_shop.payload.product.ProductForm;
import com.food_shop.repo.sales.PromotionRepo;
import com.food_shop.service.others.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/public/demo")
public class TestController {

    @Autowired
    private PromotionRepo promotionRepo;

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/promotion/check-valid")
    public ResponseEntity<JsonResult> getOrderInfo(@RequestParam("username") String username,
                                                   @RequestParam("cp-code") String couponCode) {
        return promotionRepo.findValidByCustomerAndCouponCode(username, couponCode)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }

    @GetMapping("/promotion/applied")
    public ResponseEntity<JsonResult> applyPromotion(@RequestParam("id-user") Integer idUser,
                                                   @RequestParam("cp-code") String couponCode) {
        return JsonResult.success(promotionRepo.updatePromotionUse(idUser, couponCode));
    }

    @GetMapping("/mail")
    public ResponseEntity<JsonResult> sendRandomMail(@RequestParam("send-to") String toEmail,
                                                     @RequestParam("header") String header,
                                                     @RequestParam("content") String content) {
        if (sendMailService.sendHtmlMail(toEmail, header, content)) {
            return JsonResult.success("Done sending mail");
        }
        return JsonResult.badRequest("Fail to send mail");
    }

    @PostMapping("/product/update")
    public ResponseEntity<JsonResult> updateProduct(@RequestBody ProductForm productForm) {
        System.out.println(productForm);
        return JsonResult.success("Form submitted");
    }
}
