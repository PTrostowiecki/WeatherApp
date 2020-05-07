package com.myprivate.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTempraturesDto {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;

    public double getTemp(){



        double celcius;

        celcius = temp - 273.15;

        temp = celcius;
        BigDecimal bigDecimal = new BigDecimal(temp).setScale(1,RoundingMode.UP);
        double newTemp = bigDecimal.doubleValue();

        temp = newTemp;

        return temp;

    }


}
