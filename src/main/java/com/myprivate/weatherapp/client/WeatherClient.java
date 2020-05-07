package com.myprivate.weatherapp.client;


import com.myprivate.weatherapp.model.OpenWeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${open.weather.map.api.key}")
    private String weatherApiKeyId;

    public OpenWeatherDto getForecast(@RequestParam String city,String location){

        URI url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q",city,location)
                .queryParam("wind.speed.unit","m/h")
                .queryParam("appid",weatherApiKeyId).build().encode().toUri();

        OpenWeatherDto response = restTemplate.getForObject(url,OpenWeatherDto.class);

        return response;

    }

}
