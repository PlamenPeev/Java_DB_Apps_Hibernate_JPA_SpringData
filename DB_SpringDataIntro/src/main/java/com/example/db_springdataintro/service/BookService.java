package com.example.db_springdataintro.service;

import com.example.db_springdataintro.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;


    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByFirstNameAndLastNameOrderByReleaseDate(String firstName, String lastName);
}
