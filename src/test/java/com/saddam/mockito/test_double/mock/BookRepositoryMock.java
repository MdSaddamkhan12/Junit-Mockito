package com.saddam.mockito.test_double.mock;

import com.saddam.mockito.test_double.spy.Book;
import com.saddam.mockito.test_double.spy.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;
    @Override
    public void save(Book book) {

        saveCalled++;
        lastAddedBook = book;
    }

    public void verify(Book book, int times){
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);

    }

}
