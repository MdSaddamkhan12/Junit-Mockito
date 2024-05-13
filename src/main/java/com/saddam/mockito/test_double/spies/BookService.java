package com.saddam.mockito.test_double.spies;

import com.saddam.mockito.test_double.stubbing.BookRepository;
import com.saddam.mockito.test_double.stubbing.BookRequest;

import java.util.List;

public class BookService {


    public Book findBook(String bookId) {
        // Code to bring book from database
         // method not implemented
         throw new RuntimeException("Method not Implemented");
    }

    public int getAppliedDiscount(Book book, int discountRate) {

        int price = book.getPrice();
        int newPrice = price - (price * discountRate / 100);
        return newPrice;
    }
}
