package com.food_shop.entities.result_mappings.dto;

import com.food_shop.entities.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAccount {

    private Integer idProd;

    private String prodName;

    private String image;

    private Integer price;

    private Long consumption;
}
