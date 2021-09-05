package com.hackerrank.weather.repository.customRepository.helpers;

import com.hackerrank.weather.dto.form.AbstractSortingForm;
import com.hackerrank.weather.model.sorting.ISortType;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.util.CollectionUtils;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Stream;

public abstract class RepositoryHelper {


    public static OrderSpecifier[] getOrders(@Nullable final ISortType sortType, @Nullable Order order) {
        if (sortType == null) {
            return new OrderSpecifier[0];
        }
        if (order == null) {
            order = Order.ASC;
        }

        return sortType.of(order);
    }

    public static OrderSpecifier<?>[] getOrders(List<? extends AbstractSortingForm> sorting) {
        if (CollectionUtils.isEmpty(sorting)) {
            return new OrderSpecifier[0];
        }
        return sorting
                .stream()
                .map(RepositoryHelper::getOrders)
                .flatMap(Stream::of)
                .toArray(OrderSpecifier[]::new);
    }

    public static OrderSpecifier<?>[] getOrders(AbstractSortingForm sorting) {
        return getOrders(sorting.getType(), sorting.getOrder());
    }
}