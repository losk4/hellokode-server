package com.loska.hellokode.controller;

import com.loska.hellokode.model.MovieSearchResponse;
import com.loska.hellokode.service.MovieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchController {

    private MovieServiceImpl movieService;

    @GetMapping("/movie")
    public Mono<MovieSearchResponse> getMovies(
            @RequestParam(name = "query", defaultValue = "") String query,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        return movieService.getMovies(query, page);
    }

}
