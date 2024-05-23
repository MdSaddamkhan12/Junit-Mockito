package com.saddam.mockito.test_double.behavior.verification;

import java.time.LocalDate;

public interface BookRepository {
    void save(Book book);

    Book findBookById(String bookId);
}
