package com.example.demo;

import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class WebTest {
    private WebTestClient client;

    @Test
    public void test() throws Exception {
        this.client = WebTestClient.bindToController(new TestController()).build();

        this.client.get().uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("It works!");
    }


    @RestController
    static class TestController {

        @GetMapping("/test")
        public String handle() {
            return "It works!";
        }
    }
}
