package com.saddam.mockito.test_double.bdd.stubbing;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }
    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){

       List<Book>  newBooks = bookRepository.findNewBook(days);

       //500 apply 10% -> 10% discount on 500 -> 50 -> 500 - 50 = 450

        for(Book book : newBooks){
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }


}
