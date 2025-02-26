package com.example.TM30;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication(exclude = {ReactiveManagementWebSecurityAutoConfiguration.class, ReactiveSecurityAutoConfiguration.class})
public class Tm30Application {

	public static void main(String[] args) {
		SpringApplication.run(Tm30Application.class, args);
	}

}
