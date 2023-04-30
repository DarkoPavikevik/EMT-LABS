package com.example.labemt.service;

import com.example.labemt.model.Author;
import com.example.labemt.model.Book;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void create(String name, String surname, Long countryId);

    Optional<Author> findByNameAndSurname(String name, String surname);

    Optional<Author> findById(Long id);
    List<Author> findAll();
}
