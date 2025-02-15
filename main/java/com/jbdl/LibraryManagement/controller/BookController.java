package com.jbdl.LibraryManagement.controller;

import com.jbdl.LibraryManagement.constants.BookFilter;
import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.dto.response.BookDto;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

   @PostMapping
   public BookDto createBook(@Validated @RequestBody com.jbdl.LibraryManagement.dto.request.BookDto request){

       return bookService.createBook(request);

   }

   @GetMapping("/filter")
    public List<Book> filterBook(@RequestParam BookFilter filterBy, @RequestParam Operator operator,
                           @RequestParam String value){

       return bookService.filterBooks(filterBy,operator,value);


   }

//    switch(filterBy) {
//        case BOOK_NO:
//            switch(operator){
//                case EQUALS :
//
//
//                case NOTEQUALS:
//            }
//
//        case BOOK_AUTHOR:
//
//        case BOOK_TYPE:
//    }
}
