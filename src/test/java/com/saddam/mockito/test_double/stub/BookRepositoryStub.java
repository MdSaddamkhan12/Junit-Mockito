package com.saddam.mockito.test_double.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBook(int days) {

        List<Book> newBook = new ArrayList<>();

        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        newBook.add(book1);
        newBook.add(book2);
        return newBook;
    }
}
