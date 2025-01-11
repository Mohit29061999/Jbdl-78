package com.db.springDbDemo.db.controller;

import com.db.springDbDemo.db.model.Person;
import com.db.springDbDemo.db.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //using request body
    @PostMapping("/person")
    public int addPerson(@RequestBody Person person){

        return personService.addPerson(person);
    }

    //create a new Person record using Query params
    @PostMapping("/person/param")
    public int addPersonParam(@RequestParam(value = "name") String name,@RequestParam(value = "id",
    required = false) Integer id){
        Person person = new Person(id,name);
        //Person person = new Person(name);
        return personService.addPerson(person);
    }

    @GetMapping("/person/{id}")
    public Person getPersonByid(@PathVariable int id){
        return personService.getPersonByid(id);
    }




}
