package com.food_shop.service_impl.sales;

import com.food_shop.entities.sales.Sales;
import com.food_shop.repo.sales.SalesRepo;
import com.food_shop.service.sales.SalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesServiceImpl.class);

    @Autowired
    private SalesRepo salesRepo;

    @Override
    public List<Sales> findByOrder(Integer idOrder) {
        try {
            return salesRepo.findByOrder(idOrder);
        } catch (Exception ex) {
            LOGGER.error("findByOrder error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Sales> findByProduct(Integer idOrder) {
        return null;
    }

    @Override
    public List<Sales> findByQtyRange(int lowerBound, int upperBound) {
        return null;
    }
}
