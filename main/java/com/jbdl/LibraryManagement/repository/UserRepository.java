package com.jbdl.LibraryManagement.repository;

import com.jbdl.LibraryManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
