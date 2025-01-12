package com.db.springDbDemo.db.repo;

import com.db.springDbDemo.db.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;


//java class and primary key
//you are using SimpleJPA repository
public interface JpaImpl extends JpaRepository<MyPerson,Integer> {
}
