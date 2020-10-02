package com.food_shop.entities.result_mappings.mappings;


import com.food_shop.entities.product.Product;
import com.food_shop.entities.result_mappings.dto.ProductAccount;
import com.food_shop.entities.result_mappings.dto.ProductCategoryAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "ProductAccountMapping",
                classes = @ConstructorResult(
                        targetClass = ProductAccount.class,
                        columns = {
                                @ColumnResult(name = "id_prod"),
                                @ColumnResult(name = "prod_name"),
                                @ColumnResult(name = "prod_image"),
                                @ColumnResult(name = "price"),
                                @ColumnResult(name = "consumption", type = Long.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "ProductCategoryAccountMapping",
                classes = @ConstructorResult(
                        targetClass = ProductCategoryAccount.class,
                        columns = {
                                @ColumnResult(name = "id_prod"),
                                @ColumnResult(name = "prod_name"),
                                @ColumnResult(name = "prod_image"),
                                @ColumnResult(name = "category"),
                                @ColumnResult(name = "cat_name"),
                                @ColumnResult(name = "max_prod_qty", type = Long.class)
                        }
                )
        )
})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResultMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMapping;
}
