package com.hackerrank.weather.controller;

import com.hackerrank.weather.dto.WeatherDto;
import com.hackerrank.weather.dto.form.WeatherForm;
import com.hackerrank.weather.dto.form.WeatherSearchForm;
import com.hackerrank.weather.exceptions.NotFoundException;
import com.hackerrank.weather.mappers.WeatherMapper;
import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.services.WeatherService;
import com.hackerrank.weather.utils.DateTimeFormats;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(WeatherApiRestController.ROOT_URL)
@RequiredArgsConstructor
public class WeatherApiRestController {
    public static final String ROOT_URL = "/weather";
    private static final String ONE_URL = "/{id}";

    private final WeatherMapper weatherMapper;
    private final WeatherService weatherService;


    @PostMapping
    public ResponseEntity<WeatherDto> createWeather(@RequestBody WeatherForm form) {
        Weather weather = weatherService.save(form);
        return new ResponseEntity<>(weatherMapper.apply(weather), HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping
    public ResponseEntity<List<WeatherDto>> getAllCountries(@RequestParam(value = "city", required = false) String city,
                                                            @RequestParam(value = "sort", required = false) String sort,
                                                            @RequestParam(value = "date", required = false) String date) {
        WeatherSearchForm form = WeatherSearchForm.builder()
                .city(Optional.ofNullable(city).orElse(null))
                .date(date != null ? DateTimeFormats.dateFormatYMDViaHyphen.parse(date) : null)
                .sort(Optional.ofNullable(sort).orElse(null))
                .build();

        List<Weather> weather = weatherService.search(form);
        return new ResponseEntity<>(weatherMapper.apply(weather), HttpStatus.OK);
    }
    @GetMapping(ONE_URL)
    public ResponseEntity<WeatherDto> getWeather(@PathVariable Integer id) {
        Weather weather = weatherService.take(id);
        return new ResponseEntity<>(weatherMapper.apply(weather), HttpStatus.OK);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public void notFoundException(final NotFoundException exception) {
        log.error(exception.getMessage());
    }
}
