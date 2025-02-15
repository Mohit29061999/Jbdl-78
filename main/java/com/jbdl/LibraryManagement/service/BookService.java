package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.constants.Operator;
import com.jbdl.LibraryManagement.dto.response.BookDto;
import com.jbdl.LibraryManagement.exception.BookException;
import com.jbdl.LibraryManagement.model.Author;
import com.jbdl.LibraryManagement.model.Book;
import com.jbdl.LibraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFilterFactory bookFilterFactory;

    public BookDto createBook(com.jbdl.LibraryManagement.dto.request.BookDto request) {
        //check if this author already exists or not
        //make a db query for author here
        Author author = authorService.findAuthorByEmail(request.getAuthorEmail());

        if(author == null){
            //create and save this author in db
            author = Author.builder().name(request.getAuthorName())
                    .email(request.getAuthorEmail()).build();

            //we aren't saving author to db
            //author = authorService.createAuthor(author);
        }

        //create a book
        Book currentBook = request.createBook();
        currentBook.setAuthor(author);

        currentBook = bookRepository.save(currentBook);



        return BookDto.builder().bookNo(currentBook.getBookNo()).bookType(currentBook.getBookType())
                .build();
    }

    public List<Book> filterBooks(com.jbdl.LibraryManagement.constants.BookFilter filterBy, Operator operator, String value) {
        BookFilter bookFilterService = bookFilterFactory.getBookFilterSevice(filterBy);

        return bookFilterService.filterBook(operator, value);
    }

    public Book getBookByNo(String bookNo){
        List<Book> books = bookRepository.findByBookNo(bookNo);
        if(books.size()==0){
            throw new BookException("book doesn't exist");
        }
        return books.get(0);
    }

    public boolean isBookTaken(Book book){
        return book.getUser()==null;
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }
}
