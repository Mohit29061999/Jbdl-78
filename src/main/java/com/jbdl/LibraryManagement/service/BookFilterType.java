package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFilterType implements BookFilter {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> filterBook(Operator operator, String value) {
        if(operator == Operator.EQUALS || operator == Operator.NOTEQUALS) {

            if (operator == Operator.EQUALS) {
                //string value to enum value
                //it is throwing here
                return bookRepository.findByBookType(com.jbdl.LibraryManagement.constants.BookType.valueOf(value));
            }
        }

        return null;
    }
}
