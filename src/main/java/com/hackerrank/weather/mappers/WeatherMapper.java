package com.hackerrank.weather.mappers;

import com.hackerrank.weather.dto.WeatherDto;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.utils.DateTimeFormats;
import com.hackerrank.weather.web.constants.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
@Component
@RequiredArgsConstructor
public class WeatherMapper extends DtoMapper<Weather, WeatherDto> {
    SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_PATTERN_YMD);


    @Override
    public WeatherDto apply(Weather weather) {
        return WeatherDto.builder()
                .city(weather.getCity())
                .id(weather.getId())
                .date(DateTimeFormats.dateFormatYMDViaHyphen.format(weather.getDate()))
                .latitude(weather.getLat())
                .longitude(weather.getLon())
                .state(weather.getState())
                .temperatures(weather.getTemperatures())
                .build();
    }
}
