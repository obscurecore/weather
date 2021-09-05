package com.hackerrank.weather.repository.customRepository.helpers;

import com.hackerrank.weather.dto.form.WeatherSearchForm;
import com.hackerrank.weather.model.QWeather;
import com.querydsl.core.BooleanBuilder;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
public class WeatherRepositoryHelper extends RepositoryHelper {

    private static final QWeather weather = QWeather.weather;

    public static BooleanBuilder getPredicates(final WeatherSearchForm form) {
        final BooleanBuilder predicates = new BooleanBuilder();

        if (form.getCity() != null && !form.getCity().isEmpty()) {
            for (String city : form.getCity()) {
                predicates.or(weather.city.equalsIgnoreCase(city));
            }
        }

        if (form.getDate() != null) {
            predicates.and(weather.date.eq(form.getDate()));
        }
        return predicates;
    }
}
