package com.saddam.mockito.test_double.bdd.stubbing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StubTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testStubbingInTraditionalMockitoStyle(){



        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        List<Book> newBook = new ArrayList<>();
        newBook.add(book1);
        newBook.add(book2);

        when(bookRepository.findNewBook(7)).thenReturn(newBook);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    @DisplayName("Given - new Books, When - Get New Books With Applied Discount Is Called, Then - New Books With Applied Discount Is Returned")
    public void test_Given_newBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_NewBooksWithAppliedDiscountIsReturned(){

        //Arrange - Given
        Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

        List<Book> newBook = new ArrayList<>();
        newBook.add(book1);
        newBook.add(book2);

        given(bookRepository.findNewBook(7)).willReturn(newBook);

        // Act - When
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        //Assert - Then
       /* assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450,newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,newBooksWithAppliedDiscount.get(1).getPrice());*/

        //Assertj - BDDAssertions
        then(newBooksWithAppliedDiscount).isNotNull();
        then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
        then(newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
    }

}
