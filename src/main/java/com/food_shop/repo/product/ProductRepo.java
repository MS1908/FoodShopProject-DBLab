package com.food_shop.repo.product;

import com.food_shop.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>, ProductRepoCustom {

    @Query(value = "select c from Product c where c.deleted = false and c.idProd = ?1")
    Optional<Product> findById(Integer idProd);

    @Query(value = "select c from Product c where c.deleted = false")
    List<Product> findAll();

    @Query(value = "select c from Product c where c.deleted = false and c.category.idCat = ?1")
    List<Product> findByCategory(Integer idCat);

    @Query(value = "select top 4 * from Product p " +
            "where " +
            "p.deleted = 0" +
            "and p.id_prod <> ?1 " +
            "and p.category = (select p1.category from Product as p1 where p1.id_prod = ?1)",
            nativeQuery = true)
    List<Product> findRelated(Integer idProd);

    @Modifying
    @Transactional
    @Query(value = "update Product o set o.deleted = true where o.idProd = ?1")
    int deleteByIdProd(Integer idProd);
}
