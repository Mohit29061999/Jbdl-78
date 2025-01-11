package com.db.springDbDemo.db.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private Integer id;
    private String name;

    public Person(String name){
        this.name = name;
    }


}
