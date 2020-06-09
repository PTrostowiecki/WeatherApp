package com.myprivate.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WeatherappApplication {


	public static void main(String[] args) {
		SpringApplication.run(WeatherappApplication.class, args);
	}

}
