package com.spring.chapter_2.Configurations;

import com.spring.chapter_2.Auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl") //for Auditing coz AuditableEntity requires config class
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

	@Bean
	public AuditorAware<String> getAuditorAwareImpl(){
		return new AuditorAwareImpl();
	}
	 
}
