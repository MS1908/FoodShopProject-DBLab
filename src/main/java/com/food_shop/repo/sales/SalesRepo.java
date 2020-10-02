package com.food_shop.repo.sales;

import com.food_shop.entities.product.Product;
import com.food_shop.entities.sales.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepo extends JpaRepository<Sales, Integer> {

    @Query(value = "select s from Sales s where s.order.idOrder = ?1")
    List<Sales> findByOrder(Integer idOrder);

    @Query(value = "select s from Sales s where s.product.idProd = ?1")
    List<Sales> findByProduct(Integer idOrder);

    @Query(value = "select s from Sales s " +
            "where (0 = ?1 or s.quantity > ?1) and (0 = ?2 or s.quantity < ?1)")
    List<Sales> findByQtyRange(int lowerBound, int upperBound);
}
