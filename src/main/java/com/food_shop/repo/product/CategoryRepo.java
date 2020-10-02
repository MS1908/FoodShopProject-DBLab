package com.food_shop.repo.product;

import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query(value = "select c from Category c where c.idCat = ?1")
    Optional<Category> findById(Integer idCat);

    @Query(value = "select c from Category c order by priority, id")
    List<Category> findAll();

    @Query(value = "select distinct c.priority from Category c order by c.priority")
    List<Integer> findAllPriorities();
}
