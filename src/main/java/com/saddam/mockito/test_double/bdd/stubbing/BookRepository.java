package com.saddam.mockito.test_double.bdd.stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBook(int days);
}
