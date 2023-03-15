package com.loska.hellokode.controller;

import com.loska.hellokode.model.MovieSearchResponse;
import com.loska.hellokode.service.MovieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class MovieController {

    private MovieServiceImpl movieService;

    @GetMapping("/search")
    public Mono<MovieSearchResponse> getMovies(
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        return movieService.getMovies(query, page);
    }

}
