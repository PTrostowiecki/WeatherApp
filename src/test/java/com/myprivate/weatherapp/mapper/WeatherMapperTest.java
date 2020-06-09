package com.myprivate.weatherapp.mapper;

import com.myprivate.weatherapp.model.WeatherDto;
import com.myprivate.weatherapp.model.WeatherTempraturesDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class WeatherMapperTest {

    @Test
    public void shouldMapOpenWeatherDtoToOpenWeatherEntity(){

        //given
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCity("London");
        weatherDto.setLocation("GB");
        weatherDto.setTemperatureUnits("metric");
        WeatherTempraturesDto weatherTempraturesDto = new WeatherTempraturesDto();
        weatherTempraturesDto.setTemp(17.0);
        weatherDto.setWeatherTempraturesDto(weatherTempraturesDto);
        WeatherMapper weatherMapper = new WeatherMapper();

        //when
        double temperature = weatherMapper.mapToOpenWeatherEntity(weatherDto).getTemp();

        //then
        Assertions.assertEquals(weatherTempraturesDto.getTemp(),temperature);

    }

}
