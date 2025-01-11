package com.db.springDbDemo.db.repo;

import com.db.springDbDemo.db.model.Person;

import java.util.List;

public interface PersonRepo {

    List<Person> getAllPerson();

    int addPerson(Person person);

    Person getPersonByid(int id);
}
