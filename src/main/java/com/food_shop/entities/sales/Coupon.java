package com.food_shop.entities.sales;

import com.food_shop.entities.product.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "dbo", name = "Coupon")
public class Coupon {

    @Id
    @Column(name = "cp_code")
    private String couponCode;

    private Integer discount;

    @Column(name = "expired_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
}
