package com.saddam.mockito.test_double.behavior.verification;

import com.saddam.mockito.test_double.stubbing.BookRequest;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }
    public void addBook(Book book){
        if(book.getPrice() <= 500){
            return;
        }
        bookRepository.save(book);
    }

    public void addBook(BookRequest bookRequest){

        if(bookRequest.getPrice() <= 500){
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }



}