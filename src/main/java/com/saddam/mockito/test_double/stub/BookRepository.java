package com.saddam.mockito.test_double.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findNewBook(int days);
}
