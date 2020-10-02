package com.food_shop.entities.sales;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(schema = "dbo", name = "Sales")
public class Sales {

    @EmbeddedId
    private SalesId salesId;

    @JsonIgnore
    @MapsId("orderId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", referencedColumnName = "id_order")
    private Orders order;

    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "prod_id", referencedColumnName = "id_prod")
    private Product product;

    @Column(name = "qty")
    private Integer quantity;
}
