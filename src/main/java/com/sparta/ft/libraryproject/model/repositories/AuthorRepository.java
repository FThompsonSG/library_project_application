package com.sparta.ft.libraryproject.model.repositories;

import com.sparta.ft.libraryproject.model.entities.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {
    AuthorDTO findByFullNameIgnoreCase(String fullName);
    @Transactional
    @Modifying
    @Query("update AuthorDTO a set a.id = ?1, a.fullName = ?2")
    void updateIdAndFullNameBy(Integer id, String fullName);

    Optional<AuthorDTO> findAuthorByFullName(String fullName);
}