package com.food_shop.entities.result_mappings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryAccount {

    private Integer idProd;

    private String prodName;

    private String image;

    private Integer idCat;

    private String catName;

    private Long qty;

}
