package com.myprivate.weatherapp.client;

import com.myprivate.weatherapp.model.WeatherConditionsDto;
import com.myprivate.weatherapp.model.WeatherDto;
import com.myprivate.weatherapp.model.WeatherTempraturesDto;
import com.myprivate.weatherapp.model.WeatherWindDto;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.web.client.RestTemplate;


import java.net.URI;

import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class WeatherClientTest {

    @InjectMocks
    private WeatherClient weatherClient;

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private List<WeatherConditionsDto> weatherConditionsDtoList;

    @Autowired
    private WeatherConditionsDto weatherConditionsDto;
    @Autowired
    private WeatherTempraturesDto weatherTempraturesDto;

    @Autowired
    private WeatherWindDto weatherWindDto;

    @Test
    void shouldConnectWithClientApiAndGetForecast() throws Exception {
        //given
        weatherConditionsDto.setMainWeather("test");
        weatherConditionsDto.setDescriptionOfWeather("test");
        weatherTempraturesDto.setTemp(14.5);
        weatherTempraturesDto.setFeelsLike(15.6);
        weatherTempraturesDto.setTempMax(12.4);
        weatherTempraturesDto.setTempMin(212.3);
        weatherWindDto.setWindSpeed(21.3);
        weatherConditionsDtoList.add(weatherConditionsDto);
        WeatherDto weatherDto = new WeatherDto("London",
                "GB", "metric",
                weatherConditionsDtoList, weatherTempraturesDto, weatherWindDto);
        URI uri = new URI("http://test.com/data/weather?city=London&location=GB&temperatureUnits=metric");
        when(restTemplate.getForObject(uri, WeatherDto.class)).thenReturn(weatherDto);
        //when
        WeatherDto fetchedWeatherDtoFromClient = weatherClient.getForecast("Frankfurt", "De", "metric");

        //then
        assertNotEquals(weatherDto.getCity(), fetchedWeatherDtoFromClient.getCity());
        assertEquals("Frankfurt", fetchedWeatherDtoFromClient.getCity());

    }
}
