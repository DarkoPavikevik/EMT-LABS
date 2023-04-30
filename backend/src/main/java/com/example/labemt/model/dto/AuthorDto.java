package com.example.labemt.model.dto;

import com.example.labemt.model.Country;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AuthorDto {
    private String name;

    private String surname;

    @OneToOne
    private Country country;

    public AuthorDto(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public AuthorDto() {

    }
}
