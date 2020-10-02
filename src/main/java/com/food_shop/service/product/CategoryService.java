package com.food_shop.service.product;

import com.food_shop.entities.product.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(Integer idCat);

    List<Category> findAll();

    List<Integer> findAllPriorities();

    Optional<Category> upload(Category category);
}
