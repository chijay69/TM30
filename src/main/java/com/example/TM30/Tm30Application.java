package com.example.TM30;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class Tm30Application {

	public static void main(String[] args) {
		SpringApplication.run(Tm30Application.class, args);
	}

}
