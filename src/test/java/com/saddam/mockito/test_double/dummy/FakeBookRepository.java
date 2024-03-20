package com.saddam.mockito.test_double.dummy;

import com.saddam.mockito.test_double.dummy.Book;
import com.saddam.mockito.test_double.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    //In memory database, Map or List
    Map<String, Book> bookStore = new HashMap<>();
    @Override
    public void save(Book book) {

        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
