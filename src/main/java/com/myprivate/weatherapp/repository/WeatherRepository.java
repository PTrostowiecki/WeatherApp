package com.myprivate.weatherapp.repository;

import com.myprivate.weatherapp.model.OpenWeather;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository  extends CrudRepository<OpenWeather,Long> {

    @Override
    List<OpenWeather> findAll();

    @Override
    OpenWeather save(OpenWeather openWeather);
}
