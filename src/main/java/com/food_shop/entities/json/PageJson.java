package com.food_shop.entities.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class PageJson {
    private List<?> currentElements;
    private Integer totalPages;
    private Long totalElements;

    public static PageJson build(Page<?> page) {
        return new PageJson(page.getContent(), page.getTotalPages(), page.getTotalElements());
    }
}
