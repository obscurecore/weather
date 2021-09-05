package com.hackerrank.weather.dto.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackerrank.weather.web.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 05.09.2021
 *
 * @author Ruslan Potapov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class WeatherForm {

    private Integer id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = AppConstants.DATE_PATTERN_YMD)
    private Date date;
    @JsonProperty("lat")
    private Float latitude;
    @JsonProperty("lon")
    private Float longitude;
    private String city;
    private String state;
    private List<Double> temperatures;
}

