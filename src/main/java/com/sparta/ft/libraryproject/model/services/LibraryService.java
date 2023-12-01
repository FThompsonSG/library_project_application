package com.sparta.ft.libraryproject.model.services;

import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import com.sparta.ft.libraryproject.model.entities.BookDTO;
import com.sparta.ft.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ft.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

//    public List<AuthorDTO> findAuthorsWithMoreThanOneBook(AuthorRepository authorRepository) {
//
//    }

    public List<BookDTO> findAutoBiographies(BookRepository bookRepository, String fullAuthorName) {

        List<BookDTO> resultBookList = new ArrayList<>();
        List<BookDTO> bookList = bookRepository.findAll();

        for (BookDTO book : bookList) {
            if (book.getTitle().contains(book.getAuthor().getFullName())) {
                resultBookList.add(book);
            }
        }
        return resultBookList;
    }

}
