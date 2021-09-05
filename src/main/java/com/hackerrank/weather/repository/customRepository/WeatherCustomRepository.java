package com.hackerrank.weather.repository.customRepository;

import com.hackerrank.weather.dto.form.WeatherSearchForm;
import com.hackerrank.weather.model.Weather;

import java.util.List;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
public interface WeatherCustomRepository {
    List<Weather> search (WeatherSearchForm form);
}
