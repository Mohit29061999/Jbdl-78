package com.jbdl.LibraryManagement.repository;

import com.jbdl.LibraryManagement.model.Author;
import com.jbdl.LibraryManagement.model.AuthorCompositeKey;
import org.hibernate.mapping.Selectable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {

    //3 ways
    //select * from author where email=:email
    Author findByEmail(String email);

    //2nd way
    @Query(value = "select a from Author a where email= :email",nativeQuery = false)
    Author getAuthor(String email);

    //3rd way
    @Query(value = "select a from author a where email= :email",nativeQuery = true)
    Author getAuthorByEmail(String email);


}
