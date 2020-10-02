package com.food_shop.controller;

import com.food_shop.security.SecurityConstants;
import com.food_shop.service.app_user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RequestController {

    @GetMapping(value = "/access-denied")
    public String redirectDeniedPage(HttpServletRequest request, HttpServletResponse response) {
        return "401";
    }


    @GetMapping(value = "/home")
    public String redirectHomePage(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }

    @GetMapping(value = "/shop")
    public String redirectShopPage(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "cat", required = false) Integer idCat) {
        return "shop";
    }

    @GetMapping(value = "/product")
    public String redirectProductPage(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer idProd) {
        return "product-single";
    }

    @GetMapping(value = "/about")
    public String redirectAboutPage(HttpServletRequest request, HttpServletResponse response) {
        return "about";
    }

    @GetMapping(value = "/cart")
    public String redirectCartPage(HttpServletRequest request, HttpServletResponse response) {
        return "cart";
    }

//    @RolesAllowed()
    @GetMapping(value = "/checkout")
    public String redirectCheckoutPage(HttpServletRequest request, HttpServletResponse response) {
        return "checkout";
    }

    @GetMapping(value = "/contact")
    public String redirectContactPage(HttpServletRequest request, HttpServletResponse response) {
        return "contact";
    }

    @GetMapping(value = "/login")
    public String redirectLoginPage(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @GetMapping(value = "/register")
    public String redirectRegisterPage(HttpServletRequest request, HttpServletResponse response) {
        return "register";
    }

    @GetMapping(value = "/wish-list")
    public String redirectWishlistPage(HttpServletRequest request, HttpServletResponse response) {
        return "wish-list";
    }


}
