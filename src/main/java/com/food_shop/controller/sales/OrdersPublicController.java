package com.food_shop.controller.sales;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.payload.sales.OrderForm;
import com.food_shop.service.sales.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/public/order")
public class OrdersPublicController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/info")
    public ResponseEntity<JsonResult> getOrderInfo(@RequestParam("id") Integer idOrder) {
        return ordersService.findFullInfoById(idOrder)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }
}