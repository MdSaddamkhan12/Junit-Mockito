package com.saddam.mockito.test_double.exception_handling;

import com.saddam.mockito.test_double.stubbing.BookRequest;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks(){

        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            // Log the exception
            throw new DatabaseReadException("Unable to read from database due to - " + e.getMessage());
        }
        int totalPrice = 0;
        for(Book book : books){

            totalPrice  = totalPrice + book.getPrice();
        }
        return totalPrice;
    }

    public void addBook(Book book){

        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            //log the exception
            throw new DatabaseWriteException("Unable to write into the database due to - " + e.getMessage());
        }
    }
}
