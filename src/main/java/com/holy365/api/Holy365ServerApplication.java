package com.holy365.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication()
public class Holy365ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Holy365ServerApplication.class, args);
	}

}