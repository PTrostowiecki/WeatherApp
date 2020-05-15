package com.myprivate.weatherapp.service;

import com.myprivate.weatherapp.model.OpenWeather;
import com.myprivate.weatherapp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService {

    @Autowired
    private WeatherRepository repository;

    public List<OpenWeather> getAllOpenWeathers(){
        return repository.findAll();
    }

    public OpenWeather saveOpenWeather(final OpenWeather openWeather){
        return repository.save(openWeather);
    }

    public void deleteOpenWeather(final Long id){
        repository.deleteById(id);
    }

    public void deleteAllOpenWeathers(){
        repository.deleteAll();
    }



}
