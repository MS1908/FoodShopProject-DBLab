package com.food_shop.controller.product;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.service.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/public/category")
public class CategoryPublicController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/id")
    public ResponseEntity<JsonResult> findById(@RequestParam("id") Integer idCat) {
        return categoryService.findById(idCat)
                .map(JsonResult::found)
                .orElse(JsonResult.idNotFound());
    }

    @GetMapping("/all")
    public ResponseEntity<JsonResult> findAll() {
        return Optional.ofNullable(categoryService.findAll())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }
}
