package com.saddam.mockito.test_double.dummy;

import java.util.Collection;

public interface BookRepository {

    void save(Book book);
    Collection<Book> findAll();
}
