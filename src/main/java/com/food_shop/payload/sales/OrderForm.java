package com.food_shop.payload.sales;

import com.food_shop.entities.sales.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private String username;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String coupon;
    private List<CartItem> cartItems;
}
