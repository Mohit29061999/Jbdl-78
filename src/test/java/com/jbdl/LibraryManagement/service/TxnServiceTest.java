package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.dto.request.TxnDto;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.exception.UserException;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.model.Txn;
import com.jbdl.LibraryManagement.model.User;
import com.jbdl.LibraryManagement.repository.TxnRepository;
import com.jbdl.LibraryManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TxnServiceTest {

    //dummy object of class UserService
    @Mock
    private UserService userService;


    @Mock
    private TxnRepository txnRepository;

    @Mock
    private BookService bookService;

    @InjectMocks
    private TxnService txnService ;

    @Test
    public void testCreateTxn() throws UserException {
        TxnDto txnDto = TxnDto.builder().bookNo("book1").userId(1).build();

        User newUser = User.builder().name("Alex xu").email("a@gmail.com").id(1).build();
        Book book = Book.builder().bookNo("book1").title("Intro to System Design").securityAmount(60.0)
                .build();
        Txn txn = Txn.builder().id("txn1").book(book).user(newUser).build();

        when(userService.isUserValid(1)).thenReturn(newUser);
        when(bookService.getBookByNo("book1")).thenReturn(book);
        when(bookService.isBookTaken(book)).thenReturn(true);
        doNothing().when(bookService).updateBook(book);
        when(txnRepository.save(any())).thenReturn(txn);



        String id = txnService.createTxn(txnDto);
        assertEquals("txn1",id);
    }

    @Test
    public void testCreateTxnWithNullBook() throws Exception {
        TxnDto txnDto = TxnDto.builder().bookNo("book1").userId(1).build();

        User newUser = User.builder().name("Alex xu").email("a@gmail.com").id(1).build();
        Book book = Book.builder().bookNo("book1").title("Intro to System Design").securityAmount(60.0)
                .build();
        Txn txn = Txn.builder().id("txn1").book(book).user(newUser).build();

        when(userService.isUserValid(1)).thenReturn(newUser);
        when(bookService.getBookByNo("book1")).thenReturn(null);

       assertThrows(BookException.class,() -> txnService.createTxn(txnDto));

    }

    @Test
    public void testCreateTxnWithNullUser() throws Exception {
        TxnDto txnDto = TxnDto.builder().bookNo("book1").userId(1).build();

        User newUser = User.builder().name("Alex xu").email("a@gmail.com").id(1).build();
        Book book = Book.builder().bookNo("book1").title("Intro to System Design").securityAmount(60.0)
                .build();
        Txn txn = Txn.builder().id("txn1").book(book).user(newUser).build();

        when(userService.isUserValid(1)).thenReturn(null);


        assertThrows(UserException.class,() -> txnService.createTxn(txnDto));

    }




}
