package com.saddam.mockito.test_double.annotations.support;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBook(int days);
}
