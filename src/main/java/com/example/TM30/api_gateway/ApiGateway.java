package com.example.TM30.api_gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApiGateway {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/products/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://localhost:8080/products"))
                .route("order-service", r -> r.path("/orders/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://localhost:8080/orders"))
                .route("home-service", r -> r.path("/")
                        .uri("lb://localhost:8080/home"))
                .build();
    }
}