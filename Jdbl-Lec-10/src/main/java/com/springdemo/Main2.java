package com.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("projectBean.xml");

        //to get bean back
        Student student = (Student)context.getBean("student");
        System.out.println(student);
        // System.out.println(student);

        //check if same object is used by both refrence
//        Student student1 = (Student)context.getBean("student");
//        System.out.println(student.equals(student1));
//
//        System.out.println(student.getAddress().equals(student1.address));
    }
}
