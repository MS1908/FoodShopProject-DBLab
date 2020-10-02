package com.food_shop.controller.product.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.product.Category;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.payload.product.ProductForm;
import com.food_shop.service.product.CategoryService;
import com.food_shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/category")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/priorities")
    public ResponseEntity<JsonResult> findAllPriorities() {
        return Optional.ofNullable(categoryService.findAllPriorities())
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("Category not found"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @PostMapping("/upload")
    public ResponseEntity<JsonResult> upload(@RequestBody Category category) {
        return categoryService.upload(category)
                .map(JsonResult::uploaded)
                .orElse(JsonResult.saveError("Internal Server Error"));
    }

}
