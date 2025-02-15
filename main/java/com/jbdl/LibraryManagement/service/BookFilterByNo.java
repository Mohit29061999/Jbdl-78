package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFilterByNo implements BookFilter {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> filterBook(Operator operator, String value) {
        if(operator != Operator.EQUALS || operator!= Operator.NOTEQUALS){
            throw new BookException("operator should be equals only");
        }
        if(operator ==Operator.EQUALS) {
            return bookRepository.findByBookNo(value);
        }
        //not case
        //find all book
        //find book with current id and remove these book from all book
        return null;
    }
}
