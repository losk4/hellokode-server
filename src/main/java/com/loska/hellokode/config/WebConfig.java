package com.loska.hellokode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    public WebClient tmdbClient() {
        String url = "https://api.themoviedb.org/3/search/movie";
        return WebClient.create(url);
    }

}
