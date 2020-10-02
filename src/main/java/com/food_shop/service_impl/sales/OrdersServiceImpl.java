package com.food_shop.service_impl.sales;

import com.food_shop.entities.result_mappings.dto.CustomerSpense;
import com.food_shop.entities.sales.Orders;
import com.food_shop.entities.sales.Promotion;
import com.food_shop.entities.sales.Sales;
import com.food_shop.entities.sales.SalesId;
import com.food_shop.payload.sales.OrderForm;
import com.food_shop.repo.app_user.AppUserRepo;
import com.food_shop.repo.sales.OrdersRepo;
import com.food_shop.repo.product.ProductRepo;
import com.food_shop.repo.sales.PromotionRepo;
import com.food_shop.repo.sales.SalesRepo;
import com.food_shop.service.sales.OrdersService;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PromotionRepo promotionRepo;

    @Override
    public Optional<Orders> findById(Integer idOrder) {
        try {
            return ordersRepo.findById(idOrder);
        } catch (Exception ex) {
            LOGGER.error("findById error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Orders> findFullInfoById(Integer idOrder) {
        try {
            return ordersRepo.findById(idOrder)
                    .map(order -> {
                        order.setSalesList(salesRepo.findByOrder(idOrder));
                        return Optional.of(order);
                    })
                    .orElse(Optional.empty());
        } catch (Exception ex) {
            LOGGER.error("findById error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Orders> findByCustomer(Integer idAppUser) {
        try {
            return ordersRepo.findByCustomer(idAppUser);
        } catch (Exception ex) {
            LOGGER.error("findByCustomer error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<CustomerSpense> findCustomerSpense() {
        try {
            return ordersRepo.findCustomerSpense();
        } catch (Exception ex) {
            LOGGER.error("findCustomerSpense error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Orders> findAll() {
        try {
            return ordersRepo.findAll();
        } catch (Exception ex) {
            LOGGER.error("findAll error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Orders> findForAdmin() {
        try {
            return ordersRepo.findForAdmin();
        } catch (Exception ex) {
            LOGGER.error("findForAdmin error", ex);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public Optional<Orders> submit(OrderForm of) {
        try {
            Promotion promotion = new Promotion();
            System.out.println("Coupon is -" + of.getCoupon() + "-");
            if (of.getCoupon() != null && !of.getCoupon().equals("")) {
                 promotion = promotionRepo.findValidByCustomerAndCouponCode(of.getUsername(), of.getCoupon()).orElse(null);
                if (promotion == null) throw new HibernateException("Can't insert new Food_Order");
            }

            Orders o = Orders.builder()
                    .date(new Date())
                    .customerName(of.getFullName())
                    .address(of.getAddress())
                    .email(of.getEmail())
                    .phone(of.getPhone())
                    .customer(appUserRepo.findByUsername(of.getUsername()).orElse(null))
                    .totalCost(1000000000.0)
                    .processStatus(Orders.OrdersStatus.SUBMITTED)
                    .paymentStatus(Orders.PaymentStatus.UNPAID)
                    .build();
            if (ordersRepo.save(o) == null) throw new HibernateException("Can't insert new Food_Order");

            List<Sales> salesList = of.getCartItems()
                    .stream()
                    .map(cartItem -> {
                        return Sales.builder()
                                .salesId(new SalesId(o.getIdOrder(), cartItem.getIdProd()))
                                .order(o)
                                .product(productRepo.findById(cartItem.getIdProd()).orElse(null))
                                .quantity(cartItem.getQty())
                                .build();

                    })
                    .collect(Collectors.toList());
            if (salesRepo.saveAll(salesList) == null) throw new HibernateException("Can't insert new Food_Order");

            o.setCoupon(promotion.getCoupon());
            o.setSalesList(salesList);
            o.setTotalCost(o.calculateTotalCost());
            promotionRepo.updatePromotionUse(o.getCustomer().getIdUser(), of.getCoupon());
            return Optional.ofNullable(ordersRepo.save(o));

        } catch (Exception ex) {
            LOGGER.error("submitOrder error", ex);
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean cancel(Integer idOrder) {
        try {
            return ordersRepo.findById(idOrder)
                    .map(ord -> {
                        if (ord.getPaymentStatus() || ord.getProcessStatus().equals(Orders.OrdersStatus.SHIPPING)) {
                            return false;
                        }
                        return ordersRepo.updateProcessStatus(Orders.OrdersStatus.CANCELLED, idOrder) > 0;
                    })
                    .orElse(false);

        } catch (Exception ex) {
            LOGGER.error("updateOrderProcessStatus error", ex);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProcessStatus(Integer newOrderProcessStatus, Integer idOrder) {
        try {
            return ordersRepo.updateProcessStatus(newOrderProcessStatus, idOrder) > 0;
        } catch (Exception ex) {
            LOGGER.error("updateOrderProcessStatus error", ex);
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePaymentStatus(Boolean newOrderPaymentStatus, Integer idOrder) {
        try {
            return ordersRepo.updatePaymentStatus(newOrderPaymentStatus, idOrder) > 0;
        } catch (Exception ex) {
            LOGGER.error("updateOrderPaymentStatus error", ex);
            ex.printStackTrace();
            return false;
        }
    }
}
