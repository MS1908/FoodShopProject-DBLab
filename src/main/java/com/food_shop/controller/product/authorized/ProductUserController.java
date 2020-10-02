package com.food_shop.controller.product.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.product.Product;
import com.food_shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer/product")
public class ProductUserController {

    @Autowired
    private ProductService productService;

    @GetMapping("/consumption")
    public ResponseEntity<JsonResult> findProductInfoByUser(@RequestParam("username") String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUsername = authentication.getName();
            if (!currentUsername.equals(username)) return JsonResult.badRequest("Get the fuck out boo!");
        }
        return Optional.ofNullable(productService.findProductInfoByUser(username))
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Product ìnfo by user not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }
}
