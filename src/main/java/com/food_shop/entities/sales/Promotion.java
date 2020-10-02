package com.food_shop.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.food_shop.entities.app_user.AppUser;
import com.food_shop.entities.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "dbo", name = "Promotion")
public class Promotion {

    @EmbeddedId
    private PromotionId promotionId;

    @MapsId("couponCode")
    @ManyToOne(optional = false)
    @JoinColumn(name = "cp_code", referencedColumnName = "cp_code")
    private Coupon coupon;

    @JsonIgnore
    @MapsId("customerId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "cus_id", referencedColumnName = "id_user")
    private AppUser customer;

    private Boolean used;
}
