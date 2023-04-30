package com.example.labemt.service.Imp;

import com.example.labemt.model.Country;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImp implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void create(String name, String continent) {
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
    }
}
