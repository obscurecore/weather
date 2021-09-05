package com.hackerrank.weather.services;

import com.hackerrank.weather.dto.form.WeatherForm;
import com.hackerrank.weather.dto.form.WeatherSearchForm;
import com.hackerrank.weather.exceptions.NotFoundException;
import com.hackerrank.weather.exceptions.types.ErrorTypes;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public Weather take(Integer weatherId) {
        log.debug("Getting user by id {}", weatherId);
        return find(weatherId)
                .orElseThrow((() -> new NotFoundException(ErrorTypes.NOT_FOUND)));
    }

    public Optional<Weather> find(@NonNull Integer weatherId) {
        return weatherRepository.findById(weatherId);
    }

    public Weather save(@NonNull WeatherForm form) {
        Weather weather = fill(form);
        weatherRepository.save(weather);
        return weather;
    }

    public Weather fill(@NonNull WeatherForm form) {
        return Weather.builder()
                .city(form.getCity())
                .date(form.getDate())
                .lat(form.getLatitude())
                .lon(form.getLongitude())
                .state(form.getState())
                .temperatures(form.getTemperatures())
                .build();
    }

    public List<Weather> search(@NonNull WeatherSearchForm form) {
        return weatherRepository.search(form);
    }
}
