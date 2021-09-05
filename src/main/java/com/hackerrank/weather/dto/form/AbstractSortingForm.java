package com.hackerrank.weather.dto.form;

import com.hackerrank.weather.model.sorting.ISortType;
import com.querydsl.core.types.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractSortingForm {
    private static final Order DEFAULT_ORDER = Order.DESC;

    private Order order = DEFAULT_ORDER;
    public abstract ISortType getType();
}