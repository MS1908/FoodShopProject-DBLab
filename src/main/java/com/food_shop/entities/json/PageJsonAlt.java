package com.food_shop.entities.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PageJsonAlt<K, V> {

    private Map<K, List<V>> content;
    private Integer totalPages;
    private Long totalElements;
}
