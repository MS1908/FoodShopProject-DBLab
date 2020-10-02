package com.food_shop.repo.product;

import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductAccount;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepoCustom {
    List<Product> findBestSellers();

    List<ProductCategoryAccount> findBestSellersByCategory();

    List<ProductCategoryAccount> findBestSellersByCategoryByMonth(int month);

    List<ProductCategoryAccount> findSaleStatisticByDate(String beginDate, String endDate);

    List<ProductAccount> findProductInfoByUser(String username);
}
