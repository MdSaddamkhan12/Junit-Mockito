package com.saddam.mockito.test_double.spies;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook(String bookId, int  discountRate){

        Book book = bookService.findBook(bookId); // We need to mock
        int discountedRate = bookService.getAppliedDiscount(book, discountRate); // we  need to actually call
        return discountedRate;


    }
}
