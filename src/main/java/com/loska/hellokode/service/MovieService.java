package com.loska.hellokode.service;

import com.loska.hellokode.model.MovieSearchResponse;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<MovieSearchResponse> getMovies(String query, Integer page);

}
