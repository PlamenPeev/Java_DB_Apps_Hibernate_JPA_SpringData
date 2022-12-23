package com.example.db_springdataintro.service;

import com.example.db_springdataintro.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
