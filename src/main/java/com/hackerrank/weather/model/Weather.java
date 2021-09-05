package com.hackerrank.weather.model;

import com.hackerrank.weather.model.sorting.ISortType;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
public class Weather {

    public static final String GENERATOR = "seq_generator";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;

    private Float lat;
    private Float lon;
    private String city;
    private String state;

    @Column(name = "temperatures_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection(targetClass = Double.class)
    @CollectionTable(name = "weather_temperatures_ids", joinColumns = @JoinColumn(name = "weather_id"))
    private List<Double> temperatures;


    public Weather(Integer id, Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public Weather(Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public Weather() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Double> temperatures) {
        this.temperatures = temperatures;
    }

    public enum SortType implements ISortType {

        ID(QWeather.weather.id),
        DATE(QWeather.weather.date);

        @Getter
        private ComparableExpressionBase[] expressions;

        SortType(ComparableExpressionBase... expressions) {
            this.expressions = expressions;
        }
    }
}
