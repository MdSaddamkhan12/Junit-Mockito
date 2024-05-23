package com.saddam.mockito.test_double.argument_matchers;

import java.time.LocalDate;

public interface BookRepository {
    void save(Book book);

    Book findBookById(String bookId);

    Book findBookByTitleAndPublishDate(String title, LocalDate localDate);
}
