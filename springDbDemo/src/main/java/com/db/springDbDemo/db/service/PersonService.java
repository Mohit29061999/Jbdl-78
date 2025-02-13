package com.db.springDbDemo.db.service;

import com.db.springDbDemo.db.model.MyPerson;
import com.db.springDbDemo.db.model.Person;
import com.db.springDbDemo.db.repo.JpaImpl;
import com.db.springDbDemo.db.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //service layer will call db layer
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private JpaImpl jpaImpl;

    public List<Person> getAllPerson(){
      return personRepo.getAllPerson();
    }

    public int addPerson(Person person){
        return personRepo.addPerson(person);
    }

    public Person getPersonByid(int id){
        return  personRepo.getPersonByid(id);
    }

    public List<MyPerson> getAllMyPerson(){
        return jpaImpl.findAll();
    }

    public MyPerson createMyPerson(MyPerson person){
        return jpaImpl.save(person);
    }


}
