package com.saddam.mockito.test_double.bdd.vehavior_verification;

import com.saddam.mockito.test_double.stubbing.BookRequest;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }
    public void updatePrice(String bookId, int updatedPrice){

       Book book = bookRepository.findBookById(bookId);
       book.setPrice(updatedPrice);
       bookRepository.save(book);
    }
}
