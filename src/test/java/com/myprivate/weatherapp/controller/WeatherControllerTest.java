package com.myprivate.weatherapp.controller;

import com.myprivate.weatherapp.model.WeatherDto;
import com.myprivate.weatherapp.model.WeatherEntity;
import com.myprivate.weatherapp.repository.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WeatherController weatherController;


    @Test
    public void shouldGetWeatherFromOpenWeatherApi() throws Exception{
        //given
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setCity("London");
        weatherDto.setLocation("GB");
        weatherDto.setTemperatureUnits("metric");
        when(weatherController.getWeather("London","GB","metric")).thenReturn(weatherDto);
        //when & then
        mockMvc.perform(get("/forecast/getweather?city=London&location=GB&temperatureUnits=metric").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))//or isOK()
                .andExpect(jsonPath("$.name", is("London")) )
                .andExpect(jsonPath("$.temperatureUnits", is("metric")) )
                .andExpect(jsonPath("$.location", is("GB")) );
    }

    @Test
    public void shouldGetWeatherListFromWeatherRepository() throws Exception{
        //given
        WeatherEntity weatherEntity1 = new WeatherEntity();
        WeatherEntity weatherEntity2 = new WeatherEntity();
        weatherEntity1.setCity("London");
        weatherEntity1.setLocation("GB");
        weatherEntity2.setCity("Frankfurt");
        weatherEntity2.setLocation("DE");
        List<WeatherEntity> weatherEntityList = new ArrayList<>();
        weatherEntityList.add(weatherEntity1);
        weatherEntityList.add(weatherEntity2);
        when(weatherController.getWeatherList()).thenReturn(weatherEntityList);
        //when & then
        mockMvc.perform(get("/forecast/getweatherlist").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))//or isOK()
                .andExpect(jsonPath("$",hasSize(2)));
    }
    @Test
    public void shouldClearWeatherDataBase() throws Exception{
        //given
        Mockito.doNothing().when(weatherController).clearWeatherDataBase();
        //when & then
        mockMvc.perform(delete("/forecast/deleteall").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));//or isOK()

    }
    @Test
    public void shouldDeleteWeatherByIdFromDataBase() throws Exception{
         //given & when & then
         mockMvc.perform(delete("/forecast/deletebyid?id=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));//or isOK()



    }

}
