package com.hackerrank.weather.repository.customRepository.impl;

import com.hackerrank.weather.dto.form.WeatherSearchForm;
import com.hackerrank.weather.model.QWeather;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.customRepository.WeatherCustomRepository;
import com.hackerrank.weather.repository.customRepository.helpers.WeatherRepositoryHelper;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
@RequiredArgsConstructor
@Repository
public class WeatherCustomRepositoryImpl implements WeatherCustomRepository {
    private static final QWeather weather = QWeather.weather;
    private final EntityManager entityManager;

    @Override
    public List<Weather> search(WeatherSearchForm form) {
        final List<Weather> query = new  JPAQuery<Weather>(entityManager)
                .from(weather)
                .where(WeatherRepositoryHelper.getPredicates(form))
                .orderBy(WeatherRepositoryHelper.getOrders(form.getSorting()))
                .fetch();
        return query;
    }
}
