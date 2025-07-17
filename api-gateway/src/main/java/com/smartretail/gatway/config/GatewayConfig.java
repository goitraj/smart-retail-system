package com.smartretail.gatway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("http://localhost:8081"))
                .route("product-service", r -> r.path("/api/products/**")
                        .uri("http://localhost:8082"))
                .route("order-service", r -> r.path("/api/orders/**")
                        .uri("http://localhost:8083"))
                .route("inventory-service", r -> r.path("/api/inventory/**")
                        .uri("http://localhost:8084"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://localhost:8085"))
                .build();
    }
}
