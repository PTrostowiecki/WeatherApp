package com.myprivate.weatherapp.service;

import com.myprivate.weatherapp.repository.WeatherRepository;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.myprivate.weatherapp.model.WeatherEntity;
import java.util.List;


@SpringBootTest
public class DataBaseServiceTest {

    @Autowired
    private WeatherRepository repository;
    @Autowired
    private DataBaseService dataBaseService;
    private WeatherEntity weatherEntity1 = new WeatherEntity();
    private WeatherEntity weatherEntity2 = new WeatherEntity();

    @BeforeEach
    public  void  clearWeatherRepository(){
        repository.deleteAll();
    }

    @Test
    public void shouldGetAllWeathersFromWeatherRepository(){
        //given
        repository.save(weatherEntity1);
        repository.save(weatherEntity2);
        //when
        List<WeatherEntity> list = dataBaseService.getAllOpenWeathersEntity();
        //then
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void shouldSaveWeatherEntityInWeatherRepository(){
        //given
        dataBaseService.saveOpenWeatherEntity(weatherEntity1);
        //when
        int sizeOfWeatherRepository = dataBaseService.getAllOpenWeathersEntity().size();
        //then
        Assert.assertEquals(1,sizeOfWeatherRepository);
    }

    @Test
    public void shouldDeleteWeatherByIdFromWeatherRepository(){
        //given
        dataBaseService.saveOpenWeatherEntity(weatherEntity1);
        dataBaseService.saveOpenWeatherEntity(weatherEntity2);
        Long id = weatherEntity1.getId();
        //when
        dataBaseService.deleteOpenWeatherEntity(id);
        //then
        Assert.assertEquals(1, dataBaseService.getAllOpenWeathersEntity().size());
    }

    @Test
    public void shouldDeleteAllWeathersEntity(){
        //given
        dataBaseService.saveOpenWeatherEntity(weatherEntity1);
        dataBaseService.saveOpenWeatherEntity(weatherEntity2);
        //when
        dataBaseService.deleteAllOpenWeathersEntity();
        int sizeOfWeatherRepository = dataBaseService.getAllOpenWeathersEntity().size();
        //then
        Assert.assertNotEquals(2,sizeOfWeatherRepository);
        Assert.assertEquals(0,sizeOfWeatherRepository);
    }





}
