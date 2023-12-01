package com.sparta.ft.libraryproject.model.repositories;

import com.sparta.ft.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {
    BookDTO findFirstByTitleContainsIgnoreCaseAndAuthor_FullNameContainsIgnoreCaseOrderByTitleAscAuthor_FullNameAsc(String title, String fullName);
}