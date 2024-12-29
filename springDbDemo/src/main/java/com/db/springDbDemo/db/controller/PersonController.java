package com.db.springDbDemo.db.controller;

import com.db.springDbDemo.db.model.Person;
import com.db.springDbDemo.db.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    //controller calls service layer
    //all buiness logic is in service layer
    @Autowired
    private PersonService personService;


    //get all person record from db
    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
}
