package com.myprivate.weatherapp.controller;

import com.myprivate.weatherapp.client.WeatherClient;
import com.myprivate.weatherapp.mapper.OpenWeatherMapper;
import com.myprivate.weatherapp.model.OpenWeather;
import com.myprivate.weatherapp.model.OpenWeatherDto;
import com.myprivate.weatherapp.repository.WeatherRepository;
import com.myprivate.weatherapp.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forecast/")
public class OpenWeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private DataBaseService dataBaseService;

    @Autowired
    private OpenWeatherMapper openWeatherMapper;

    @Autowired
    private WeatherClient weatherClient;

    @RequestMapping(method = RequestMethod.GET, value = "getweather")
    public OpenWeatherDto getWeather(@RequestParam String city,
                                     @RequestParam(required = false) String location,
                                     @RequestParam(defaultValue = "metric", value = "temperatureUnits") String temperatureUnits){
        OpenWeatherDto openWeatherDto = weatherClient.getForecast(city,location,temperatureUnits);
        dataBaseService.saveOpenWeather(openWeatherMapper.mapToOpenWeather(openWeatherDto));

        return openWeatherDto;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getweatherlist")
    public List<OpenWeather> getOpenWeatherList(){
        return  weatherRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteall")
    public void clearWeatherDataBase(){
        weatherRepository.deleteAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletebyid")
    public void deleteWeatherByIdFromDataBase(@RequestParam Long id ){
        weatherRepository.deleteById(id);
    }

}
