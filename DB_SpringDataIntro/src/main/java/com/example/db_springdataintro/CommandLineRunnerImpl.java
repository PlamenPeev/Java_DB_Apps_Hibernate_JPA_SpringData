package com.example.db_springdataintro;

import com.example.db_springdataintro.model.entity.Book;
import com.example.db_springdataintro.service.AuthorService;
import com.example.db_springdataintro.service.BookService;
import com.example.db_springdataintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printAllBooksAfterYear(2000);
        //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsOfTheirBooks();
        printAllBooksByAuthorsNameOrderByReleaseDate("George", "Powell");

    }

    private void printAllBooksByAuthorsNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByFirstNameAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);

    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);

    }

    private void printAllBooksAfterYear(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
