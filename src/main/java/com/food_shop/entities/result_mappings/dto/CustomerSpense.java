package com.food_shop.entities.result_mappings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSpense {

    private String username;
    private Double totalSpense;
}
