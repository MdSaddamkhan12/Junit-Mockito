package com.saddam.mockito.test_double.stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBook(int days);

    Book findBookByBookId(String bookId);

}
