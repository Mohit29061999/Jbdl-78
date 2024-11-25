package com.hashCode;

import java.util.Objects;

//Product -> name,type
//equals is handy


public class Student {
    String name;
    String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //define condition when two objects are equal
    @Override
    public boolean equals(Object o) {

        //if they belong to different class then will never be equal and
        //return case
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
       return id.equals(student.id);
    }


    //if two objects are equal then hashcode should be same
    //two unequal objects can have same hashcode
    @Override
    public int hashCode() {
        return Objects.hash( id);
    }

    public static void main(String[] args){
      Student student1 = new Student("Mohit","1");
        Student student2 = new Student("Rohit","1");

        System.out.println(student1.equals(student2));

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());





    }
}
