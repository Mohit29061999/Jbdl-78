package com.db.springDbDemo.db.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//when we have this class a table in db use this annotation
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "people")
public class MyPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "person", unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private String dob;


    //don't store it in db
    //to not store something in db
    @Transient
    private Integer age;
}
