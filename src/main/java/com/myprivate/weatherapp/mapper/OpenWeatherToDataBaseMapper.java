package com.myprivate.weatherapp.mapper;

import com.myprivate.weatherapp.model.OpenWeather;
import com.myprivate.weatherapp.model.OpenWeatherDto;
import com.myprivate.weatherapp.model.WeatherTempraturesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OpenWeatherToDataBaseMapper {

    @Mapping(source = "weathertemperaturesdto.temp", target = "temp")
    @Mapping(source = "openweatherdto.city", target = "city")
    @Mapping(source = "openweatherdto.location", target = "location")
    @Mapping(source = "openweatherdto.unit", target = "unit")
    OpenWeather from(WeatherTempraturesDto weathertemperaturesdto, OpenWeatherDto openweatherdto );

}
