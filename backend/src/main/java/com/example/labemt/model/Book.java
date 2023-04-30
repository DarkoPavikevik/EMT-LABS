package com.example.labemt.model;

import com.example.labemt.model.enumeration.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne
    private Author author;

    private Integer  availableCopies;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
