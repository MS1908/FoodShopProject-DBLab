package com.food_shop.controller;


import com.food_shop.entities.app_user.AppUser;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminRequestController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping(value = "")
    public String redirectAdminPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin";
    }

    @GetMapping(value = "/orders")
    public String redirectAdminOrdersPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-orders";
    }

    @GetMapping(value = "/orders/details")
    public String redirectOrderDetailsPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer idOrd) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-orders-details";
    }

    @GetMapping(value = "/products")
    public String redirectProductsPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-products";
    }

    @GetMapping(value = "/products/new")
    public String redirectNewProductDetailsPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-product-details";
    }

    @GetMapping(value = "/products/details")
    public String redirectProductsDetailsPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer idProd) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-product-details";
    }

    @GetMapping(value = "/sales")
    public String redirectAdminSalesPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-sales";
    }

    @GetMapping(value = "/sales/stats")
    public String redirectAdminSalesStatisticsPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-sales-stats";
    }

    @GetMapping(value = "/sales/best-seller")
    public String redirectAdminSalesBestSellerPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-sales-best-seller";
    }

    @GetMapping(value = "/promotions")
    public String redirectAdminPromotionPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-promotions";
    }

    @GetMapping(value = "/category")
    public String redirectCategoryPage(HttpServletRequest request, HttpServletResponse response) {
        if (!appUserService.getRoleFromCookie(request).equals(AppUser.ROLE_ADMIN)) return "401";
        return "admin-category";
    }
}
