package com.db.springDbDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//bean
//pre-exisiting class and it doesn't have any bean tag
//we can't modify this class
@Component
public class ConfigTestClass {
    private String name = "GeeksForGeeks";


    //read the value from application.properties file
    public ConfigTestClass(@Value("${ConfigTestClass.name}") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
