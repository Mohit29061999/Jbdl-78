package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.model.Book;

import java.util.List;

//filter book by some criteria
public interface BookFilter {

    List<Book> filterBook(Operator operator,String value);
}
