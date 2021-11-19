package com.vvalle;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

	
@SpringBootApplication
public class VvallEApplication {

	public static void main(String[] args) {
		SpringApplication.run(VvallEApplication.class, args);
	}

	
	@Bean
	public  ModelMapper modelMapper() {
		ModelMapper modelMapper = 	 new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		return modelMapper;
	}
	
	@Bean
	public javax.validation.Validator localValidatorFactoryBean() {
	    return new LocalValidatorFactoryBean();
	}
}
