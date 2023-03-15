package com.loska.hellokode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class CorsTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldAllowAnyRequestOrigin() {
        WebTestClient.ResponseSpec response = webTestClient
                .get()
                .uri("http://localhost:8080/search")
                .header("Origin", "http://random-origin.com")
                .exchange();

        response.expectHeader()
                .valueEquals("Access-Control-Allow-Origin", "*");
    }

}
