package com.myprivate.weatherapp.mapper;

import com.myprivate.weatherapp.model.WeatherEntity;
import com.myprivate.weatherapp.model.WeatherDto;
import com.myprivate.weatherapp.model.WeatherTempraturesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherEntityToDataBaseMapper {

    @Mapping(source = "weathertemperaturesdto.temp", target = "temp")
    @Mapping(source = "openweatherdto.city", target = "city")
    @Mapping(source = "openweatherdto.location", target = "location")
    @Mapping(source = "openweatherdto.unit", target = "unit")
    WeatherEntity createOpenWeatherEntity(WeatherTempraturesDto weathertemperaturesdto, WeatherDto openweatherdto );

}
