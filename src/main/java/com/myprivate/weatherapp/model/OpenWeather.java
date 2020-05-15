package com.myprivate.weatherapp.model;


import com.myprivate.weatherapp.mapper.OpenWeatherToDataBaseMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OpenWeather implements OpenWeatherToDataBaseMapper {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "city")
    private String city;
    @Column(name = "location")
    private String location;
    @Column(name = "temperature")
    private double temp;
    @Column(name = "units")
    private String unit;
    @Column(name = "time")
    private LocalTime time = LocalTime.now();
    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Override
    public OpenWeather from(final WeatherTempraturesDto weathertemperaturesdto, final OpenWeatherDto openweatherdto) {
        OpenWeather openWeather = new OpenWeather();
        openWeather.setTemp(weathertemperaturesdto.getTemp());
        openWeather.setCity(openweatherdto.getCity());
        openWeather.setLocation(openweatherdto.getLocation());
        openWeather.setUnit(openweatherdto.getUnit().toUpperCase());
        if(openWeather.getUnit().equals("metric".toUpperCase())){
            openWeather.setUnit("Celsius");
        }else if (openWeather.getUnit().equals("imperial".toUpperCase())){
            openWeather.setUnit("Fahrenheit");
        }else{
            openWeather.setUnit("Kalvin");
        }


        return openWeather;
    }
}


