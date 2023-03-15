package com.loska.hellokode.service;

import com.loska.hellokode.model.MovieSearchResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class MovieServiceImpl {

    private final String API_KEY = "22ff991962592b38a6f4c9f05d748c3e";
    private final String LANGUAGE = "es-ES";

    private final WebClient tmdbClient;

    public Mono<MovieSearchResponse> getMovies(String query, Integer page) {
        return tmdbClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", LANGUAGE)
                        .queryParam("query", query)
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(MovieSearchResponse.class);
    }

}
