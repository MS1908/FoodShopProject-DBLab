package com.food_shop.controller.sales.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.sales.Orders;
import com.food_shop.payload.sales.OrderForm;
import com.food_shop.service.app_user.AppUserService;
import com.food_shop.service.sales.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer/order")
public class OrdersCustomerController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    public ResponseEntity<JsonResult> findByCustomer() {
        return appUserService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .map(customer -> {
                    return Optional.ofNullable(ordersService.findByCustomer(customer.getIdUser()))
                            .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                            .orElse(JsonResult.serverError("Internal Server Error"));
                })
                .orElse(JsonResult.serverError("Internal Server Error"));

    }

    @GetMapping("/id")
    public ResponseEntity<JsonResult> findById(@RequestParam("id") Integer idOrder) {
        return ordersService.findFullInfoById(idOrder)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());

    }

    @PostMapping("/submit")
    public ResponseEntity<JsonResult> submit(@RequestBody OrderForm orderForm) {
        return ordersService.submit(orderForm)
                .map(JsonResult::uploaded)
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/cancel")
    public ResponseEntity<JsonResult> cancel(@RequestParam("id") Integer idOrder) {
        if (ordersService.cancel(idOrder)) {
            return JsonResult.updated("Canceled!");
        } else {
            return JsonResult.notFound("The Orders is paid or on shipping. You cannot cancel this order.");
        }
    }

}
