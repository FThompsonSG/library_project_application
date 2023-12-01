package com.sparta.ft.libraryproject;

import com.sparta.ft.libraryproject.controller.AuthorController;
import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import com.sparta.ft.libraryproject.model.repositories.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
public class MockingTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("Test Rest Response")
    void testRestResponse() throws Exception {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setFullName("Mock Man!!");
        Mockito.when(authorRepository.findAll()).thenReturn(new ArrayList<>(List.of(mockAuthor)));
        mockMvc
                .perform(get("http://localhost:8080/authors"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("getAllAuthorsByName"))
//                .andExpect(content().toString().contains("Mock Man!!"))
                .andDo(print());

    }
}