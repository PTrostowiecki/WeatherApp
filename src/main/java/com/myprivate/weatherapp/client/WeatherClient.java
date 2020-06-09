package com.myprivate.weatherapp.client;


import com.myprivate.weatherapp.model.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class WeatherClient  {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${open.weather.map.api.key}")
    private String weatherApiKeyId;

    public WeatherDto getForecast(@RequestParam String city ,
                                  @RequestParam(required = false) String location,
                                  @RequestParam(defaultValue = "metric") String temperatureUnits){

        URI url = UriComponentsBuilder.fromHttpUrl("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q",city,location)
                .queryParam("units", temperatureUnits)
                .queryParam("appid",weatherApiKeyId).build().encode().toUri();

        try {
            WeatherDto response = restTemplate.getForObject(url, WeatherDto.class);

           response.setLocation(location);
           response.setTemperatureUnits(temperatureUnits);
            return response;
        }catch (RestClientException e){
            return new WeatherDto();
        }

    }

}
