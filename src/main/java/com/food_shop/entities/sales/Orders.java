package com.food_shop.entities.sales;

import com.food_shop.entities.app_user.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "dbo", name = "Food_Order")
public class Orders {
    private static double SHIPPING_FEE = 50000.0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer idOrder;

    //
    private Date date;

    @Column(name = "cus_name")
    private String customerName;

    private String phone;

    private String email;

    //
    private String address;

    //
    @Column(name = "total_cost")
    private Double totalCost;

    //
    @Column(name = "payment_status")
    private Boolean paymentStatus;

    //
    @Column(name = "process_status")
    private Integer processStatus;

    //
    @ManyToOne
    @JoinColumn(name = "cp_code")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser customer;

    @Transient
    List<Sales> salesList = new ArrayList<>();

    public static double getShippingFee(){
        return Orders.SHIPPING_FEE;
    }

    public static class OrdersStatus {
        public static final int CANCELLED = -1;
        public static final int SUBMITTED = 0;
        public static final int CONFIRMED = 1;
        public static final int SHIPPING = 2;
        public static final int SHIPPED = 3;
    }

    public static class PaymentStatus {
        public static final boolean UNPAID = false;
        public static final boolean PAID = true;
    }

    public double calculateTotalCost() {
        double wholeCost = salesList.stream().mapToDouble(s -> s.getQuantity() * s.getProduct().getPrice()).sum() + SHIPPING_FEE;
        if (coupon == null || coupon.getCouponCode() == null) {
            return wholeCost;
        } return wholeCost * (1 - coupon.getDiscount() / 100.00);
    }
}
