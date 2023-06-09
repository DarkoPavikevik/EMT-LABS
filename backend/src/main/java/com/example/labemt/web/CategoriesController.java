package com.example.labemt.web;

import com.example.labemt.model.enumeration.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {
    @GetMapping
    public List<Category> allCategories(){
        return Arrays.stream(Category.values()).toList();
    }
}
