package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookFilterAuthor implements BookFilter {
    @Override
    public List<Book> filterBook(Operator operator, String value) {
        return List.of();
    }
}
