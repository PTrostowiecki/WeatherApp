package com.myprivate.weatherapp.controller;

import com.myprivate.weatherapp.client.WeatherClient;
import com.myprivate.weatherapp.model.OpenWeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast/")
public class OpenWeatherController {

    @Autowired
    private WeatherClient weatherClient;

    @RequestMapping(method = RequestMethod.GET, value = "getweather")
    public OpenWeatherDto getWeather(@RequestParam String city, String location){

        return weatherClient.getForecast(city,location);
    }
}
