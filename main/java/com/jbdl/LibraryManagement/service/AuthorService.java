package com.jbdl.LibraryManagement.service;

import com.jbdl.LibraryManagement.model.Author;
import com.jbdl.LibraryManagement.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorByEmail(String email){
        return authorRepository.findByEmail(email);
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }
}
