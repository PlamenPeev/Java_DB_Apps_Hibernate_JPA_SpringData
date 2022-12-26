package com.example.db_json_processing.services;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;


public interface SeedService {
    void seedUsers() throws IOException, JAXBException;

    void seedCategories() throws IOException, JAXBException;

    void seedProducts() throws IOException, JAXBException;

    default void seedAll() throws IOException, JAXBException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}

