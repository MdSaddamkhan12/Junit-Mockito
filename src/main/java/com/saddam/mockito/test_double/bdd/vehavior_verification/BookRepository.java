package com.saddam.mockito.test_double.bdd.vehavior_verification;

public interface BookRepository {
    void save(Book book);

    Book findBookById(String bookId);
}
