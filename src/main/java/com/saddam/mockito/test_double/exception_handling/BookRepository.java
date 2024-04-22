package com.saddam.mockito.test_double.exception_handling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {

    List<Book> findAllBooks() throws SQLException;
}