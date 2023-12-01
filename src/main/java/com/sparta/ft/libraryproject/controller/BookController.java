package com.sparta.ft.libraryproject.controller;

import com.sparta.ft.libraryproject.exceptions.AuthorNotFoundException;
import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import com.sparta.ft.libraryproject.model.entities.BookDTO;
import com.sparta.ft.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ft.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public String addBook(@RequestBody BookDTO bookDTO) throws AuthorNotFoundException {
        Optional<AuthorDTO> author = authorRepository.findAuthorByFullName(bookDTO.getAuthor().getFullName());
        if (author.isEmpty()) {
            throw new AuthorNotFoundException(bookDTO.getAuthor().getFullName());
        } else {
            bookDTO.setAuthor(author.get());
            bookRepository.save(bookDTO);
            return "Book has been saved";
        }
    }

}
