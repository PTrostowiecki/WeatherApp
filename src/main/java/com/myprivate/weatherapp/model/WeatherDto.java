package com.myprivate.weatherapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {

    @JsonProperty("name")
    private String city;
    private String location;
    private String temperatureUnits;
    @JsonProperty("weather")
    private List<WeatherConditionsDto> weatherConditionsDto;
    @JsonProperty("main")
    private WeatherTempraturesDto weatherTempraturesDto;
    @JsonProperty("wind")
    private WeatherWindDto weatherWindDto;



}
