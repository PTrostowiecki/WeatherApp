package com.myprivate.weatherapp.repository;

import com.myprivate.weatherapp.model.WeatherEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository  extends CrudRepository<WeatherEntity,Long> {

    @Override
    List<WeatherEntity> findAll();

    @Override
    WeatherEntity save(WeatherEntity weatherEntity);
}
