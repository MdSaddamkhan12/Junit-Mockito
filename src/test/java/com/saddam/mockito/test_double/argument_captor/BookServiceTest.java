package com.saddam.mockito.test_double.argument_captor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Captor
    ArgumentCaptor<Book> argumentCaptor;

    @Test
    public void testSaveBook(){

        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository).save(argumentCaptor.capture());
        Book book = argumentCaptor.getValue();
        assertEquals("Mockito In Action", book.getTitle());
    }

}
