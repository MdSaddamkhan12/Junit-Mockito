package com.saddam.mockito.test_double.mock;

import com.saddam.mockito.test_double.spy.Book;
import com.saddam.mockito.test_double.spy.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockTest {

    @Test
    public void demoMock(){
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book  book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book  book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());
        bookService.addBook(book1); //return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2, 1);

    }
}

