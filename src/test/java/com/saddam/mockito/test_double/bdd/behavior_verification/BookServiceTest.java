package com.saddam.mockito.test_double.bdd.behavior_verification;

import com.saddam.mockito.test_double.behavior.verification.Book;
import com.saddam.mockito.test_double.behavior.verification.BookRepository;
import com.saddam.mockito.test_double.behavior.verification.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testUpdatePrice2(){

        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("1234")).thenReturn(book);
        bookService.updatePrice("1234", 500);
        verify(bookRepository).findBookById("1234");
        verify(bookRepository).save(book);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void tes_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated(){

        //Given - Arrange
        Book book = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        given(bookRepository.findBookById("1234")).willReturn(book);

        //When - Act
        bookService.updatePrice("1234",500);
        //Then - Assert/verify
        then(bookRepository).should().save(book);


    }
}
