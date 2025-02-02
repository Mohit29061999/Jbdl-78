package com.jbdl.LibraryManagement.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {

    @Test
    public void testEmail(){
        Author author = new Author();
        author.setEmail("m@gmail.com");
        //check if getEmail is working or not
        String actualEmail = author.getEmail();
        assertEquals("m@gmail.com",actualEmail);
    }
}
