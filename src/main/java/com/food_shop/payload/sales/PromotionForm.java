package com.food_shop.payload.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionForm {

    private String couponCode;

    private Integer discount;

    private Date expiredDate;

    private List<String> receivers;

}
