package com.serialize;

import java.io.Serializable;

//whenever an object needs to be written to outside of JVM
//we need to add this implements Serializable

//Serializable is a marker interface
//as it doesn't have anything
//placeHolder interface/validation interface

//write an object to a file
//it will get an ID
//version of class at that point when it was written to the file
//if you make any changes to the class after that
//you will get error

//if parent is seriazable then child is seriazable too
public class Student extends StudentParent {

    //use this version always
    private static final long serialVersionUID = 123456765432L;

    private String name;
    private String id;
    private String rollNo;

    public Student(String name, String id,String rollNo) {
        this.name = name;
        this.id = id;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    //two version of student class
    //one is written to file
    //other one is in the code
    //hence version mismatch

    //the version written to file as of now
    //doesn't have hashCode and below constructor
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", rollNo='" + rollNo + '\'' +
                '}';
    }
}
