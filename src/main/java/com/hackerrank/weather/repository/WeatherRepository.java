package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.customRepository.WeatherCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer>, WeatherCustomRepository {
}
