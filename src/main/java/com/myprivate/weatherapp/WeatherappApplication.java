package com.myprivate.weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WeatherappApplication {

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(WeatherappApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(WeatherappApplication.class, args);
	}

}
