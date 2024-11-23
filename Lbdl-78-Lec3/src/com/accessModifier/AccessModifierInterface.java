package com.accessModifier;


public abstract class AccessModifierInterface {

    public void publicMethod(){

    }

    protected void protectedMethod(){

    }

    private void privateMethod(){

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

    //defining method as abstract requires extra effort
    public abstract void abstractMethod();

    public abstract void nonAbstract();
}
