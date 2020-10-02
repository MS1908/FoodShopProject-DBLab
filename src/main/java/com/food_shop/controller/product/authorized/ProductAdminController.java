package com.food_shop.controller.product.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.product.Category;
import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.payload.product.ProductForm;
import com.food_shop.service.product.CategoryService;
import com.food_shop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/product")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/best-sellers/category")
    public ResponseEntity<JsonResult> findBestSellerByCategory(@RequestParam(value = "month", defaultValue = "0", required = false) Integer month) {
        Map<String, List<ProductCategoryAccount>> rs;
        if (month == 0) rs = productService.findBestSellersByCategory();
        else rs = productService.findBestSellersByCategoryByMonth(month);

        return Optional.ofNullable(rs)
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("No result returned!"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

    @PostMapping("/upload")
    public ResponseEntity<JsonResult> upload(@RequestBody ProductForm productForm) {

        return categoryService.findById(productForm.getIdCat())
                .map(cat -> {
                    return productService.upload(productForm)
                            .map(JsonResult::uploaded)
                            .orElse(JsonResult.saveError("Internal Server Error"));
                })
                .orElse(JsonResult.parentNotFound("Category doesn't exist"));
    }

    @PostMapping("/update")
    public ResponseEntity<JsonResult> update(@RequestBody ProductForm productForm) {
        return productService.update(productForm)
                .map(JsonResult::updated)
                .orElse(JsonResult.saveError("Internal Server Error"));
    }

    @PutMapping("/delete")
    public ResponseEntity<JsonResult> deleteById(@RequestParam("id") Integer idProd) {
        if (productService.deleteById(idProd)) {
            return JsonResult.deleted();
        }
        return JsonResult.saveError("Internal Server Error");
    }

}
