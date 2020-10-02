package com.food_shop.service.sales;

import com.food_shop.entities.result_mappings.dto.CustomerSpense;
import com.food_shop.entities.sales.Orders;
import com.food_shop.payload.sales.OrderForm;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    Optional<Orders> findById(Integer idOrder);

    Optional<Orders> findFullInfoById(Integer idOrder);

    List<Orders> findByCustomer(Integer idAppUser);

    List<CustomerSpense> findCustomerSpense();

    List<Orders> findAll();

    List<Orders> findForAdmin();

    Optional<Orders> submit(OrderForm orderForm);

    boolean cancel(Integer idOrder);

    boolean updateProcessStatus(Integer newOrderProcessStatus, Integer idOrder);

    boolean updatePaymentStatus(Boolean newOrderPaymentStatus, Integer idOrder);
}
