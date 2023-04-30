package com.example.labemt.service.Imp;

import com.example.labemt.model.Author;
import com.example.labemt.model.Book;
import com.example.labemt.model.enumeration.Category;
import com.example.labemt.model.exceptions.NoAuthorIdFoundException;
import com.example.labemt.model.exceptions.NoBookIdFoundException;
import com.example.labemt.model.exceptions.NoCopiesLeftException;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

   private final BookRepository bookRepository;
   private final AuthorRepository authorRepository;

    public BookServiceImp(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(NoAuthorIdFoundException::new);
        Book book = new Book(name,category,author,availableCopies);
        this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);
        this.bookRepository.delete(book);
    }

    @Override
    public void edit(Long bookId, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);
        Author author = this.authorRepository.findById(authorId).orElseThrow(NoAuthorIdFoundException::new);

        book.setName(name);
        book.setAuthor(author);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
    }

    @Override
    public void markAsTaken(Long bookId) {
        Book book = this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new);

        if(book.getAvailableCopies()>0){
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }else{
            throw new NoCopiesLeftException();
        }

        this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return Optional.of(this.bookRepository.findById(bookId).orElseThrow(NoBookIdFoundException::new));
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }
}
