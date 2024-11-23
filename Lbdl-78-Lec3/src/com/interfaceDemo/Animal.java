package com.interfaceDemo;

public interface Animal {
    //methods in interface are public by default
      void eat();

      //add some methods in Animal
      default void speak() {
          System.out.println("This Animal doesn't speak");
      }

      //backward compatabiltiy

      default int add(int a,int b){
          return a+b;
      }

//      default void sleep(){
//
//      }

     // void sleep();

     static void move(){
          System.out.println("It is moving");
     }

}
