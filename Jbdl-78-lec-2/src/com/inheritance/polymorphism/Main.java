package com.inheritance.polymorphism;


import com.inheritance.AdvancedCalcuator;

public class Main {
    public static void main(String[] args){
     // Calculator calculator = new Calculator();
//        System.out.println(calculator.add(3,4));
//        System.out.println(calculator.add(3,4,3));


        //parent ref is superset of child ref
        Calculator calObject = new MathsCalculator();

//        //call child one here
        calObject.add(2,3);
        calObject = new Calculator();
//
//        //call parent one
        calObject.add(2,3);

        //parent to child is called downcasting
        //child to parent is called upcasting

        //check if it is called downcasting
//        Calculator newCalculator = new Calculator();
//        calObject =  new Calculator();
//        calObject.add(2,3);
//
//        //it is called upcasting
//        calObject = (MathsCalculator) new MathsCalculator();
//        calObject.add(2,3);





        //ref of parent class is pointing to child class
        //then it can only access methods defined in parent class
//        calculator.multiply(2,3);

        //Parent ref can point to child object
        //but child ref can't store parent object

        //move from child to parent
        calObject = new Calculator();
        calObject.add(2,3);


//        Calculator newCalulator = new Calculator();
//        newCalulator.add(3,4);
        MathsCalculator mathsCalculator = new MathsCalculator();
        mathsCalculator.add(3,5);

        //will give compile time error
        //MathsCalculator mathsCalculator1 = new Calculator();


    }
}
