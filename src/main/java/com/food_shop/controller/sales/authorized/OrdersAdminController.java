package com.food_shop.controller.sales.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.sales.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/order")
public class OrdersAdminController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    public ResponseEntity<JsonResult> findForAdmin() {
        return Optional.ofNullable(ordersService.findForAdmin())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Order info by admin not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/update/process-status")
    public ResponseEntity<JsonResult> updateProcess(@RequestParam("new-status") Integer newOrderStatus,
                                                    @RequestParam("id") Integer idOrder) {
        if (ordersService.updateProcessStatus(newOrderStatus, idOrder)) {
            return JsonResult.updated("Updated");
        }
        return JsonResult.serverError("Internal Server Error");

    }

    @GetMapping("/update/payment-status")
    public ResponseEntity<JsonResult> updatePayment(@RequestParam("new-status") Boolean newOrderStatus,
                                             @RequestParam("id") Integer idOrder) {
        if (ordersService.updatePaymentStatus(newOrderStatus, idOrder)) {
            return JsonResult.updated("Updated");
        }
        return JsonResult.serverError("Internal Server Error");

    }


}
