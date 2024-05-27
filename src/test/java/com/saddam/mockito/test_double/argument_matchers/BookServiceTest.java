package com.saddam.mockito.test_double.argument_matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testUpdatePrice(){

        Book book1 = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        Book book2 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
        bookService.updatePrice("1234", 500);
        verify(bookRepository).save(book2);
    }
    @Test
    public void testCollectionTypeArgumentMatchers(){

        List<Book> books  = new ArrayList<>();
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        books.add(book);
        bookService.addBooks(books);
        verify(bookRepository).saveAll(anyList()); //anySet, anyMap, anyCollection
    }

    @Test
    public void testInvalidUsOfArgumentMatchers(){
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPublishDate(eq("Mockito In Action"),any())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPublishDate("Mockito In Action", LocalDate.now());
        assertEquals("Mockito In Action", actualBook.getTitle());

        //Argument matchers should be provided for all arguments
        //Arguments matchers can't be used outside the stubbing/verification
    }

    @Test
    public void testSpecificTypeOfArgumentMatchers(){
        Book book = new Book("1234", "Mockito In Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(),anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600,true);
        assertEquals("Mockito In Action", actualBook.getTitle());

        //Argument matchers should be provided for all arguments
        //Arguments matchers can't be used outside the stubbing/verification
    }

}
