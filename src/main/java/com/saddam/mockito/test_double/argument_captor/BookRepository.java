package com.saddam.mockito.test_double.argument_captor;

public interface BookRepository {
    void save(Book book);

    Book findBookById(String bookId);
}
