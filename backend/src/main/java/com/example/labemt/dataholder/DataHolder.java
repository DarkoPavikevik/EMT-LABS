package com.example.labemt.dataholder;

import com.example.labemt.model.Author;
import com.example.labemt.model.Book;
import com.example.labemt.model.Country;
import com.example.labemt.model.enumeration.Category;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public List<Book> books = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();
    public List<Country> countries = new ArrayList<>();

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataHolder(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {

        //Countries init
        countries.add(new Country("Macedonia","Europe"));
        countries.add(new Country("Canada","North America"));
        countries.add(new Country("Argentina","South America"));
        countries.add(new Country("Albania","Europe"));



        this.countryRepository.saveAll(countries);

        //Authors init
        authors.add(new Author("Jane","Austen",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Franz","Kafka",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Charles","Dickens",countries.get((int) (Math.random() * countries.size()))));
        authors.add(new Author("Leo","Tolstoy",countries.get((int) (Math.random() * countries.size()))));


        this.authorRepository.saveAll(authors);

        //Books init
        books.add(new Book("Little Women ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Pride and Prejudice", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("A distant mirror", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Harry Potter", Category.FANTASY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("0ne and only ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Big boat ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Night king", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("See you soon", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Harry Potter 2", Category.FANTASY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Vikings ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Today is the day ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Tommorow", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("When i saw you", Category.HISTORY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Love", Category.FANTASY,authors.get((int) (Math.random() * authors.size())),20));
        books.add(new Book("Hi ", Category.CLASSICS,authors.get((int) (Math.random() * authors.size())),20));


        this.bookRepository.saveAll(books);

    }
}