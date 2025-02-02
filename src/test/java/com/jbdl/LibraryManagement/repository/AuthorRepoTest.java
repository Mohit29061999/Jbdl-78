package com.jbdl.LibraryManagement.repository;

//mysql db
//inmemory db like h2

import com.jbdl.LibraryManagement.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.datasource.url = jdbc:h2:mem:testDb",
"spring.jpa.hibernate.ddl-auto=create-drop"
})
public class AuthorRepoTest {

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    public void setUp(){
        Author author = Author.builder().name("Alex xu").email("a@gmail.com").build();
        authorRepository.save(author);
    }

    @Test
    public void testFindByEmail(){
        //findByEmail is working fine or not

        Author returnedAuthor = authorRepository.findByEmail("a@gmail.com");
        assertNotNull(returnedAuthor);
        assertEquals("Alex xu",returnedAuthor.getName());
    }

    @Test
    public void testNoMatchingRecords(){
        //findByEmail is working fine or not

        Author returnedAuthor = authorRepository.findByEmail("m@gmail.com");
        assertNull(returnedAuthor);

    }



}
