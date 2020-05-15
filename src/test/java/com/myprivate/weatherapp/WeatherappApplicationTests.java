package com.myprivate.weatherapp;


import com.myprivate.weatherapp.model.OpenWeather;
import com.myprivate.weatherapp.model.OpenWeatherDto;
import com.myprivate.weatherapp.model.WeatherTempraturesDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherappApplicationTests {

	@Test
	public void checkOpenWeatherToDataBaseMapperInterface() {
        //given


		OpenWeatherDto openWeatherDto = new OpenWeatherDto();
		openWeatherDto.setCity("London");
		WeatherTempraturesDto weatherTempraturesDto = new WeatherTempraturesDto();
		weatherTempraturesDto.setTemp(15.6);

		//when
		OpenWeather openWeather = new OpenWeather().from(weatherTempraturesDto,openWeatherDto);

         System.out.println(openWeather.getCity()+"  "+ openWeather.getTemp());
		//Then
		assertEquals(openWeather.getCity(),openWeatherDto.getCity());
		assertEquals(openWeather.getTemp(),weatherTempraturesDto.getTemp());
	}

}
