package com.hackerrank.weather.dto.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.web.constants.AppConstants;
import com.querydsl.core.types.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@Builder
public class WeatherSearchForm extends SearchableForm {

    public String sort;
    public String city;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = AppConstants.DATE_PATTERN_YMD)
    private Date date;

    public Set<String> getCity() {
        return this.city != null ? new HashSet<>(Arrays.asList(this.city.trim().split("\\s*,\\s*"))) : null;
    }

    public static final List<AdminListUsersPageSortForm> DEFAULT_SORTING = Collections.singletonList(
            AdminListUsersPageSortForm.ID_SORT);

    private List<AdminListUsersPageSortForm> sorting;

    public List<AdminListUsersPageSortForm> getSorting() {
        if (sort == null) {
            return DEFAULT_SORTING;
        }
        this.sorting = new ArrayList<>();
        this.sorting.add(new AdminListUsersPageSortForm(Weather.SortType.DATE, sort.startsWith("-") ? Order.DESC : Order.ASC));
        return sorting;
    }

    @Getter
    @NoArgsConstructor
    public static class AdminListUsersPageSortForm extends AbstractSortingForm {

        public static final AdminListUsersPageSortForm ID_SORT = new AdminListUsersPageSortForm(
                Weather.SortType.ID,
                Order.ASC
        );

        private Weather.SortType type;

        private AdminListUsersPageSortForm(Weather.SortType type, Order order) {
            super(order);
            this.type = type;
        }
    }
}

