package com.saddam.mockito.test_double.argument_matchers;

import com.saddam.mockito.test_double.stubbing.BookRequest;

import java.time.LocalDate;
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
    public void addBooks(List<Book> books){

        bookRepository.saveAll(books);
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

    public void updatePrice(String bookId, int updatedPrice){

        if(bookId == null){
            return;
        }
       Book book = bookRepository.findBookById(bookId);
        /*if(book.getPrice() == updatedPrice){
            return;
        }*/
       book.setPrice(updatedPrice);
       bookRepository.save(book);
    }


    public Book getBookByTitleAndPublishDate(String title, LocalDate localDate){
        return bookRepository.findBookByTitleAndPublishDate(title, localDate);
    }
    public Book getBookByTitleAndPriceAndIsDigital(String title, int price , boolean isDigital){
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }

}
