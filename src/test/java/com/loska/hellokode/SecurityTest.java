package com.loska.hellokode;

import com.loska.hellokode.model.Movie;
import com.loska.hellokode.model.MovieSearchResponse;
import com.loska.hellokode.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class SecurityTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void shouldNotAllowUnauthenticatedRequest() {
        webTestClient
                .get()
                .uri("http://localhost:8080/search")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    @WithMockUser
    public void shouldAllowAuthenticatedRequest() {
        webTestClient
                .get()
                .uri("http://localhost:8080/search")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK);
    }

}
