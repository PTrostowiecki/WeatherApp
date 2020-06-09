package com.myprivate.weatherapp.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherEntityTest {

     @Test
     public void shouldCreateOpenWeatherEntityFromOpenWeatherDto(){
         //given
         WeatherDto weatherDto = new WeatherDto();
         weatherDto.setCity("London");
         weatherDto.setLocation("GB");
         weatherDto.setTemperatureUnits("Kalvin");
         WeatherTempraturesDto weatherTempraturesDto = new WeatherTempraturesDto();
         weatherTempraturesDto.setTemp(17.0);
         WeatherEntity weatherEntity = new WeatherEntity();
         //when
         WeatherEntity newWeatherEntity = weatherEntity.createOpenWeatherEntity(weatherTempraturesDto, weatherDto);
         //then
         Assertions.assertEquals(weatherDto.getCity(), newWeatherEntity.getCity());
         Assertions.assertEquals(weatherDto.getLocation(), newWeatherEntity.getLocation());
         Assertions.assertEquals(weatherDto.getTemperatureUnits(), newWeatherEntity.getUnit());
         Assertions.assertEquals(weatherTempraturesDto.getTemp(), newWeatherEntity.getTemp());
     }
}
