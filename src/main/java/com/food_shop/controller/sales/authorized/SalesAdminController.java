package com.food_shop.controller.sales.authorized;


import com.food_shop.entities.json.JsonResult;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.service.product.ProductService;
import com.food_shop.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/sales")
public class SalesAdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("/stats")
    public ResponseEntity<JsonResult> findSaleStatisticsByDate(@RequestParam(value = "begin-date", defaultValue = "1970-01-01", required = false) String from,
                                                               @RequestParam(value = "end-date", defaultValue = "9999-12-31", required = false) String to) {
        List<ProductCategoryAccount> rs;
        rs = productService.findSaleStatisticByDate(from, to);

        return Optional.ofNullable(rs)
                .map(rsList -> !rsList.isEmpty() ? JsonResult.found(rsList) : JsonResult.notFound("No result returned!"))
                .orElse(JsonResult.serverError("Internal Server Error"));
    }

}
