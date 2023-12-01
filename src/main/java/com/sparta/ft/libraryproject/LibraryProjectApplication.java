package com.sparta.ft.libraryproject;

import com.sparta.ft.libraryproject.controller.AuthorController;
import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import com.sparta.ft.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ft.libraryproject.model.repositories.BookRepository;
import com.sparta.ft.libraryproject.model.services.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class LibraryProjectApplication {

    private Logger logger = Logger.getLogger(LibraryProjectApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(LibraryProjectApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
//        return args -> {
//
//            LibraryService libraryService = new LibraryService(authorRepository, bookRepository);
//            AuthorController authorController = new AuthorController(authorRepository);
//            System.out.println(authorController.getAllAuthorsByName("Fergus Thompson"));
//            System.out.println(authorController.getAllAuthorsByName(null));
//            System.out.println(authorController.deleteAuthor(3));
//            System.out.println(authorController.createNewAuthor("Bryan Cranston"));
//            System.out.println(libraryService.findAutoBiographies(bookRepository, "Fergus Thompson"));
//
//        };
//    }

}
