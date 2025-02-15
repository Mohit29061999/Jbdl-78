package com.jbdl.LibraryManagement.repository;

import com.jbdl.LibraryManagement.constants.BookFilter;
import com.jbdl.LibraryManagement.constants.BookType;
import com.jbdl.LibraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {
    public List<Book> findByBookNo(String value);

    List<Book> findByBookType(BookType value);
}
