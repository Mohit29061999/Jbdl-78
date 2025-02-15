package com.jbdl.LibraryManagement.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookFilterFactory {
    Map<com.jbdl.LibraryManagement.constants.BookFilter, BookFilter> bookFilterServiceMap = new HashMap<>();

    public BookFilterFactory(BookFilterByNo bookFilterByNo,BookFilterAuthor bookFilterAuthor,
                             BookFilterType bookFilterType){
        bookFilterServiceMap.put(com.jbdl.LibraryManagement.constants.BookFilter.BOOK_TYPE,bookFilterType);
        bookFilterServiceMap.put(com.jbdl.LibraryManagement.constants.BookFilter.BOOK_NO,bookFilterByNo);
        bookFilterServiceMap.put(com.jbdl.LibraryManagement.constants.BookFilter.BOOK_AUTHOR,bookFilterAuthor);

    }

    //method is factory method
    public BookFilter getBookFilterSevice(com.jbdl.LibraryManagement.constants.BookFilter bookFilter){
        return bookFilterServiceMap.get(bookFilter);
    }
}
