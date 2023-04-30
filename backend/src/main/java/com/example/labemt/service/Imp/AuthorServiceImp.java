package com.example.labemt.service.Imp;

import com.example.labemt.model.Author;
import com.example.labemt.model.Country;
import com.example.labemt.model.exceptions.NoAuthorIdFoundException;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public AuthorServiceImp(CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId).orElseThrow(NoAuthorIdFoundException::new);
        Author author = new Author(name,surname,country);
        this.authorRepository.save(author);
    }

    @Override
    public Optional<Author> findByNameAndSurname(String name, String surname) {
        return this.authorRepository.findByNameAndSurname(name,surname);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
