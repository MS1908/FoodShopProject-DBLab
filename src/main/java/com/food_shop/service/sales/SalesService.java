package com.food_shop.service.sales;

import com.food_shop.entities.sales.Sales;

import java.util.List;

public interface SalesService {

    List<Sales> findByOrder(Integer idOrder);

    List<Sales> findByProduct(Integer idOrder);

    List<Sales> findByQtyRange(int lowerBound, int upperBound);
}
