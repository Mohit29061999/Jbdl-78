package com.jbdl.LibraryManagement;



/**
 *
 * 1. We will have to mutiple construtor to solve all permutation and combination issue(10-15 arguments)
 * 2. We have to remember of arguments in constructor while creating the object(15-20 member variables)
 */


public class BuilderDemo {

    private String id;
    private String name;
    private String city;
    private String pincode;
    private String street;

    public BuilderDemo(BuilderClass builderClass){
        this.id = builderClass.id;
        this.name = builderClass.name;
        this.city = builderClass.city;
        this.pincode = builderClass.pincode;
        this.street = builderClass.street;
    }

    //getter and setter with return BuilderDemo
//    public BuilderDemo setId(String id){
//        this.id = id;
//        return this;
//    }


    public static class BuilderClass {
        private String id;
        private String name;
        private String city;
        private String pincode;
        private String street;

        //default constructor

        //setter
        public BuilderClass setId(String id){
            this.id = id;
            return this;
        }

        public BuilderClass setName(String name){
            this.name = name;
            return this;
        }

        public BuilderClass setCity(String city){
            this.city = city;
            return this;
        }

        public BuilderDemo build(){
            return new BuilderDemo(this);
        }



    }






}
