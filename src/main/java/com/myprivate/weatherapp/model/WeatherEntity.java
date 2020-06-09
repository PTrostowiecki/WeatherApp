package com.myprivate.weatherapp.model;


import com.myprivate.weatherapp.mapper.WeatherEntityToDataBaseMapper;
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
public class WeatherEntity implements WeatherEntityToDataBaseMapper {
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
    public WeatherEntity createOpenWeatherEntity(final WeatherTempraturesDto weathertemperaturesdto, final WeatherDto openweatherdto) {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemp(weathertemperaturesdto.getTemp());
        weatherEntity.setCity(openweatherdto.getCity());
        weatherEntity.setLocation(openweatherdto.getLocation());
        weatherEntity.setUnit(openweatherdto.getTemperatureUnits().toUpperCase());
        if(weatherEntity.getUnit().equals("metric".toUpperCase())){
            weatherEntity.setUnit("Celsius");
        }else if (weatherEntity.getUnit().equals("imperial".toUpperCase())){
            weatherEntity.setUnit("Fahrenheit");
        }else{
            weatherEntity.setUnit("Kalvin");
        }


        return weatherEntity;
    }
}


