package com.qa.starterprojects.config;

import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public String greeting() {
		return "Hello World";
		
		
	}
	
	@Bean
	public LocalTime time() {
		LocalTime x = LocalTime.now();
		return x;
				
	}
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
