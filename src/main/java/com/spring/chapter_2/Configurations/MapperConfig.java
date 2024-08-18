package com.spring.chapter_2.Configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	
	private ModelMapper modelMapper;
	 
	@Bean
	public ModelMapper modelMapper() { 
		 return setModelMapper(new ModelMapper());  
	}
	
	public ModelMapper setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		return modelMapper; 	
	}
	 
}
