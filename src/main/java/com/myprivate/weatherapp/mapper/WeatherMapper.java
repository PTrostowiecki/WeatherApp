package com.myprivate.weatherapp.mapper;

import com.myprivate.weatherapp.model.WeatherEntity;
import com.myprivate.weatherapp.model.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {

    public WeatherEntity mapToOpenWeatherEntity(final WeatherDto weatherDto){
            WeatherEntity weatherEntity = new WeatherEntity().createOpenWeatherEntity(weatherDto.getWeatherTempraturesDto(), weatherDto);

        return weatherEntity;

    }


}
