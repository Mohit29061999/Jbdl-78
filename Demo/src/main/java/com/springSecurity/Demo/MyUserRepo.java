package com.springSecurity.Demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepo extends JpaRepository<MyUser,Integer> {
    //i will give a user name here and it will give me user info for that username
    MyUser findByUsername(String username);
}
