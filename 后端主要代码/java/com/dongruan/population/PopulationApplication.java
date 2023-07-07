package com.dongruan.population;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dongruan.population.mapper")
public class PopulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopulationApplication.class, args);
	}

}
