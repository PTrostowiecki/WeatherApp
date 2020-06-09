package com.myprivate.weatherapp.service;

import com.myprivate.weatherapp.model.WeatherEntity;
import com.myprivate.weatherapp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService {

    @Autowired
    private WeatherRepository repository;

    public List<WeatherEntity> getAllOpenWeathersEntity(){
        return repository.findAll();
    }

    public WeatherEntity saveOpenWeatherEntity(final WeatherEntity weatherEntity){
        return repository.save(weatherEntity);
    }

    public void deleteOpenWeatherEntity(final Long id){
        repository.deleteById(id);
    }

    public void deleteAllOpenWeathersEntity(){
        repository.deleteAll();
    }



}
