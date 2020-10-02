package com.food_shop.repo.sales;

import com.food_shop.entities.result_mappings.dto.CustomerSpense;
import com.food_shop.entities.sales.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

    @Query(value = "select o from Orders o where o.idOrder = ?1")
    Optional<Orders> findById(Integer idOrder);

    @Query(value = "select o from Orders o where o.customer.idUser = ?1 order by o.processStatus, o.date desc")
    List<Orders> findByCustomer(Integer idAppUser);

    @Query(value = "select o from Orders o order by o.processStatus, o.paymentStatus, o.date desc")
    List<Orders> findAll();

    @Query(value = "select o from Orders o order by o.processStatus desc, o.paymentStatus desc")
    List<Orders> findForAdmin();


    @Query(value = "select new com.food_shop.entities.result_mappings.dto.CustomerSpense(o.customer.username, sum(o.totalCost)) " +
            "from Orders o " +
            //"where o.customer" +
            "group by o.customer.username")
    List<CustomerSpense> findCustomerSpense();

    @Modifying
    @Transactional
    @Query(value = "update Orders o set o.processStatus = ?1 where o.idOrder = ?2")
    int updateProcessStatus(Integer newOrderProcessStatus, Integer idOrder);

    @Modifying
    @Transactional
    @Query(value = "update Orders o set o.paymentStatus = ?1 where o.idOrder = ?2")
    int updatePaymentStatus(Boolean newOrderPaymentStatus, Integer idOrder);
}
