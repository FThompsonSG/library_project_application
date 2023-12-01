package com.sparta.ft.libraryproject.controller;

import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import com.sparta.ft.libraryproject.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/author/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Integer id) {
        return authorRepository.findById(id);
    }

//    @PutMapping("/authors")
//    public List<AuthorDTO> createNewAuthor(@RequestParam(name = "name") String name) {
//        List<AuthorDTO> authorDTOList = authorRepository.findAll();
//
//        for (AuthorDTO authorDTO : authorDTOList) {
//            if (authorDTO.getFullName().contains(name)) {
//                return authorDTOList;
//            } else {
//                AuthorDTO newAuthor = new AuthorDTO();
//                newAuthor.setFullName(name);
//                authorDTOList.add(newAuthor);
//            }
//        }
//        return authorDTOList;
//    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name) {
        List<AuthorDTO> resultList = new ArrayList<>();
        List<AuthorDTO> authorDTOList = authorRepository.findAll();

        for (AuthorDTO authorDTO : authorDTOList) {
            if (name == null) {
                resultList = authorDTOList;
            } else if (authorDTO.getFullName().contains(name)) {
                resultList.add(authorDTO);
            }
        }

        return resultList;

    }

    @PatchMapping("author/{id}")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO newAuthor, @PathVariable Integer id) {
        AuthorDTO author = null;
        if (authorRepository.findById(id).isPresent()) {
            author = authorRepository.findById(id).get();
            author.setFullName(newAuthor.getFullName());
        }
        return authorRepository.save(author);
    }

    @DeleteMapping("author/{id}")
    public List<AuthorDTO> deleteAuthor(@PathVariable Integer id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        }
        return authorRepository.findAll();
    }

}
