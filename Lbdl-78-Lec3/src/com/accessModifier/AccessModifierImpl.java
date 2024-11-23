package com.accessModifier;

//we can only increase visiblity of methods in parentClass
public abstract class AccessModifierImpl extends AccessModifierInterface{

    //protected -> public/protected
    //public -> public
    public void publicMethod(){
    //this.privateMethod();
    }

    public void protectedMethod(){

    }
    public void turnOnTv(){
        //        /****
//        System.out.println("Connection is made");
//
//         ***///
        makeWireConnection();

    }
    public void turnonFan(){
        //        /****
//        System.out.println("Connection is made");
//
//         ***///
        makeWireConnection();

    }

    public void turnOnLight(){
        //        /****
//        System.out.println("Connection is made");
//
//         ***///

        makeWireConnection();
    }

    private void makeWireConnection(){
        /****
        System.out.println("Connection is made");

         ***///
    }


}
