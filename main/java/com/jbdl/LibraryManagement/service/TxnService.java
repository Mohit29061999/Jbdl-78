package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.dto.request.TxnDto;
import com.jbdl.LibraryManagement.dto.request.TxnReturnRequest;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.exception.TxnException;
import com.jbdl.LibraryManagement.exception.UserException;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.model.Txn;
import com.jbdl.LibraryManagement.model.User;
import com.jbdl.LibraryManagement.repository.TxnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class TxnService {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private TxnRepository txnRepository;

    //by default it will only roll back on runtime exception
    @Transactional(rollbackFor = {
            UserException.class,
            BookException.class
    })
//    @Transactional
    public String createTxn(TxnDto txnDto) throws UserException,BookException {
        //user is valid or not????
        Integer userId = txnDto.getUserId();

        //check if it is a valid user or not
        User user = userService.isUserValid(userId);

        if(user == null){
            throw new UserException("user doesn't exist");
        }

        //if book is valid or not and if book is open to be taken
        Book book = bookService.getBookByNo(txnDto.getBookNo());
        if(book==null){
            throw new BookException("book with bookNo "+ txnDto.getBookNo() + " missing");
        }
       boolean canTake =  bookService.isBookTaken(book);
       if(canTake ==false){
           throw new BookException("Book is already taken");
       }

       book.setUser(user);
       bookService.updateBook(book);
//       if(true)
//       throw new UserException("book is incorrect");

       //not rolled
        Txn txn = Txn.builder().user(user).book(book).build();
        return txnRepository.save(txn).getId();




    }


    //@Transactional
    public String returnBook(TxnReturnRequest txnReturnRequest) throws UserException {
        Integer userId = txnReturnRequest.getUserId();
        User user = userService.isUserValid(userId);

        if(user == null){
            throw new UserException("user with "+ userId + " doesn't exist");
        }

        String bookNo = txnReturnRequest.getBookNo();
        Book book = bookService.getBookByNo(bookNo);
        if(book == null){
            throw new BookException("Book with bookNo "+ bookNo + " doesn't exist");
        }

        if(book.getUser() == null || book.getUser().getId()!= userId){
            throw new TxnException("book doesn't belongs to this user");
        }

        String txnId = txnReturnRequest.getTxnId();
        Txn txn = txnRepository.getById(txnId);
        LocalDate localDate = LocalDate.now();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //the two queries in child method are done
        Double fine =  calculateFine(txn.getIssueDate(),date);
        if(txn==null){
            throw new TxnException("txn is invalid");
        }


        txn.setActualReturnDate(date);

        book.setUser(null);

        //explicity update book
       // bookService.updateBook(book);


        txn = txnRepository.save(txn);
        return txn.getId();

    }

//    @Transactional(propagation = Propagation.REQUIRED)
    @Transactional(propagation = Propagation.SUPPORTS,
    isolation = Isolation.READ_COMMITTED)
    private Double calculateFine(Date d1,Date d2){

            //return diff between days
            //14 days to expected
            //22nd day 14th day 8day -> 50
           // txnRepository.save(null);
           // userService.createStudent(null);

        return null;

    }



}
