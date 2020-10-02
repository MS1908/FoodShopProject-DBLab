package com.food_shop.controller;


import com.food_shop.entities.app_user.AppUser;
import com.food_shop.security.SecurityConstants;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/customer")
public class CustomerRequestController {


    @Autowired
    private AppUserService appUserService;

    @GetMapping(value = "/checkout")
    public String redirectCustomerCheckoutPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_CUSTOMER)) return "401";
        return "checkout";
    }

    @GetMapping(value = "/orders")
    public String redirectAdminOrdersPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_CUSTOMER)) return "401";
        return "customer-orders";
    }

    @GetMapping(value = "/orders/details")
    public String redirectOrderDetailsPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer idOrd) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_CUSTOMER)) return "401";
        return "customer-order-details";
    }

    @GetMapping(value = "/products")
    public String redirectProductPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_CUSTOMER)) return "401";
        return "customer-consumption";
    }
}
