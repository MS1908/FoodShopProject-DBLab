package com.food_shop.payload.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    private Integer idProd;
    private String prodName;
    private Integer price;
    private String image;
    private Boolean deleted;
    private Integer idCat;
}
