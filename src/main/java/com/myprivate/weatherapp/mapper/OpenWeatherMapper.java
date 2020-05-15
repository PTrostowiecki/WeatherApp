package com.myprivate.weatherapp.mapper;

import com.myprivate.weatherapp.model.OpenWeather;
import com.myprivate.weatherapp.model.OpenWeatherDto;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapper {

    public OpenWeather mapToOpenWeather(final OpenWeatherDto openWeatherDto){
            OpenWeather openWeather = new OpenWeather().from(openWeatherDto.getWeatherTempraturesDto(),openWeatherDto);

        return openWeather;

    }


}
