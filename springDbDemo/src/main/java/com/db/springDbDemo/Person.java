package com.db.springDbDemo;

import lombok.*;

import java.util.Objects;

//@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

/**
 * NoArgs constructor might be needed when
 * we want to have atleast one constructor in our code
 * then default constructor will not be added by default
 * hence we need to add NoArgsConstructor
 */
public class Person {

    String name;
    int id;

    //default constructor is added only
    //if we don't have any constructor
    //if we have any constructor then default will not be adde
//    public Person(String name, int id) {
//        this.name = name;
//        this.id = id;
//    }
//
//    public Person() {
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id && Objects.equals(name, person.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, id);
//    }
}
