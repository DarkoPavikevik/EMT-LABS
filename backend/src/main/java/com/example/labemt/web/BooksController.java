package com.example.labemt.web;

import com.example.labemt.model.Book;
import com.example.labemt.model.enumeration.Category;
import com.example.labemt.service.AuthorService;
import com.example.labemt.service.BookService;
import com.example.labemt.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BooksController
{
    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;



    public BooksController(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @GetMapping({"/", "/books"})
    public List<Book> findAllBooks() {
        return this.bookService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id,
                                         @RequestParam String name,
                                         @RequestParam Long authorId,
                                         @RequestParam String category,
                                         @RequestParam Integer availableCopies) {
        Category category1 = Category.valueOf(category);
        this.bookService.edit(id, name, category1, authorId, availableCopies);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/markAsTaken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id) {
        this.bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestParam String name,
                                           @RequestParam String category,
                                           @RequestParam Long authorId,
                                           @RequestParam Integer availableCopies) {
        Category cat = Category.valueOf(category);
        this.bookService.create(name, cat, authorId, availableCopies);

        return ResponseEntity.ok().build();

    }
}
