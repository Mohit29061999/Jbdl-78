package com.jbdl.LibraryManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@IdClass(AuthorCompositeKey.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    //give a demo of composite key
    //email + name is primary key
    @Id
    private String email;

    @Id
    private String name;

    //make query to book table and search for this author
    //one query
    //getter and setter
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
