package com.food_shop.service.product;

import com.food_shop.entities.product.Category;
import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductAccount;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import com.food_shop.payload.product.ProductForm;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Integer idProd);

    List<Product> findAll();

    List<Product> findByCategory(Integer idCat);

    List<Product> findBestSellers();

    List<Product> findRelated(Integer idProd);

    Map<String, List<ProductCategoryAccount>> findBestSellersByCategory();

    Map<String, List<ProductCategoryAccount>> findBestSellersByCategoryByMonth(int month);

    List<ProductCategoryAccount> findSaleStatisticByDate(String beginDate, String endDate);

    List<ProductAccount> findProductInfoByUser(String username);

    Optional<Product> upload(ProductForm productForm);

    Optional<Product> update(ProductForm productForm);

    boolean deleteById(Integer idProd);
}
