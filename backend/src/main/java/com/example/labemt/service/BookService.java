package com.example.labemt.service;

import com.example.labemt.model.Book;
import com.example.labemt.model.enumeration.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void create(String name, Category category, Long authorId, Integer availableCopies);

    void deleteById(Long bookId);

    void edit(Long bookId,String name, Category category, Long authorId, Integer availableCopies);

    void markAsTaken(Long bookId);

    Optional<Book> findById(Long bookId);

    List<Book> findAll();
}
