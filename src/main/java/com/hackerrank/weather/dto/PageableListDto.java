package com.hackerrank.weather.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageableListDto<T> {

    private Long totalItems;
    private Integer totalPages;
    private List<T> data;

    public void setPage(Page page) {
        this.totalItems = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
