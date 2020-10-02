package com.food_shop.entities.product;

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
@Table(schema = "dbo", name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod")
    private Integer idProd;

    @Column(name = "prod_name")
    private String prodName;

    private Integer price;

    @Column(name = "prod_image")
    private String image;

    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
}
