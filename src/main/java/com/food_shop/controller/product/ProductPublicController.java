package com.food_shop.controller.product;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/public/product")
public class ProductPublicController {

    @Autowired
    private ProductService productService;

    @GetMapping("/id")
    public ResponseEntity<JsonResult> findById(@RequestParam("id") Integer idProd) {
        return productService.findById(idProd)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }

    @GetMapping("/all")
    public ResponseEntity<JsonResult> findAll() {
        return Optional.ofNullable(productService.findAll())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/cat")
    public ResponseEntity<JsonResult> findByCategory(@RequestParam("id-cat") Integer idCat) {
        return Optional.ofNullable(productService.findByCategory(idCat))
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/best-seller")
    public ResponseEntity<JsonResult> findBestSeller() {
        return Optional.ofNullable(productService.findBestSellers())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Best sellers not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @GetMapping("/related")
    public ResponseEntity<JsonResult> findRelated(@RequestParam("id") Integer idProd) {
        return Optional.ofNullable(productService.findRelated(idProd))
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Best sellers not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }


}
