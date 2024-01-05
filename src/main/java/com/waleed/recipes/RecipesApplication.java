package com.waleed.recipes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
public class RecipesApplication {

	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}

}
