package com.sparta.ft.libraryproject;

import com.sparta.ft.libraryproject.controller.AuthorController;
import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LibraryRestTest {

    private WebTestClient testClient;

    @Autowired
    private AuthorController authorController;

    @BeforeEach
    void setup() {
        testClient = WebTestClient
                .bindToController(authorController)
                .build();
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200() {
        testClient
                .get()
                .uri("http://localhost:8080/authors")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("Check that the first Author is Fergus")
    void checkThatTheFirstAuthorIsFergus() {
        testClient
                .get()
                .uri("http://localhost:8080/author/1")
                .exchange()
                .expectBody(AuthorDTO.class)
                .value(author -> assertEquals("Fergus R Thompson", author.getFullName()));
    }

}
