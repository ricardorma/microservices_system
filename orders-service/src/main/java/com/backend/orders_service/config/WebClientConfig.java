package com.backend.orders_service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.web.reactive.function.client.ServletBearerExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    // La clase añadida dentro del filter permite añadir el otken de autorizacion a las peticiones salientes
    @Bean
    @LoadBalanced
    public WebClient.Builder webClient() {
        return WebClient.builder().filter(new ServletBearerExchangeFilterFunction());
    }
}
