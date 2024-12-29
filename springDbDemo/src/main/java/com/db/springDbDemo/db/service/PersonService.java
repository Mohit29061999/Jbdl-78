package com.db.springDbDemo.db.service;

import com.db.springDbDemo.db.model.Person;
import com.db.springDbDemo.db.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //service layer will call db layer
    @Autowired
    private PersonRepo personRepo;

    public List<Person> getAllPerson(){
      return personRepo.getAllPerson();
    }
}
