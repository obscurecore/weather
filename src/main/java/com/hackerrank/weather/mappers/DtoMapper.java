package com.hackerrank.weather.mappers;

import com.hackerrank.weather.dto.PageableListDto;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class DtoMapper<E, D> implements Function<E, D> {

    public List<D> apply(List<? extends E> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }
        return items
                .stream()
                .map(this::apply)
                .collect(Collectors.toList());
    }

    public PageableListDto<D> apply(Page<? extends E> page) {
        PageableListDto<D> dto = new PageableListDto<>();
        dto.setData(apply(page.getContent()));
        dto.setPage(page);
        return dto;
    }
}