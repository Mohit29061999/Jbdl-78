package com.db.springDbDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationDemo {


    @Autowired(required = false)
    private ConfigTestClass configTestClass;

    private String name;

    public ConfigurationDemo(@Value("${ConfigurationDemo.name}") String name) {
        this.name = name;
    }
    //    @Autowired
//    private ObjectMapper objectMapper;

    public ConfigTestClass getConfigTestClass() {
        return configTestClass;
    }

    public void setConfigTestClass(ConfigTestClass configTestClass) {
        this.configTestClass = configTestClass;
    }

    public void doSomething(){
        if(configTestClass == null){
            //do something else
        }else{
            //do other thing
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
