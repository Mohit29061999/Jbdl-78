package com.stream;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamDemo {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6);

        //filter out odd values and sum their squares
        //1*1 + 3*3 + 5*5

        //int sum =0;
//        for(int i=0;i<list.size();i++){
//            if(list.get(i)%2==1){
//                int currentValue = list.get(i);
//                sum = sum+ (currentValue*currentValue);
//            }
//        }
//        System.out.println(sum);

        //we will do it with stream now

//        Integer sum = list.stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //condition on when to keep this object
//                System.out.println("inside filter "+ integer );
//                return integer%2==1;
//            }
//        }).map(new Function<Integer, Integer>() {
//
//            @Override
//            public Integer apply(Integer integer) {
//                System.out.println("inside map "+ integer );
//                  return integer*integer;
//            }
//        })
//                //{1,9,25} -> {1+9+25
//
//                .reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                System.out.println("inside reduce "+ integer + " "+ integer2);
//                return integer+integer2;
//            }
//        });


        //System.out.println(sum);

        //execution only happens if we have terminal operation
//        list.stream()
//                //to filter out some values based on some condition
//                .filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //condition on when to keep this object
//                System.out.println("inside filter "+ integer );
//                return integer%2==1;
//            }
//        })
//                //when you modify all the values
//                .map(new Function<Integer, Integer>() {
//
//            @Override
//            public Integer apply(Integer integer) {
//                System.out.println("inside map "+ integer );
//                  return integer*integer;
//            }
//        });
                //{1,9,25} -> {1+9+25

        //execution happening as we have terminal operation
        ConsumerImpl consumer = new ConsumerImpl();
       list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                //condition on when to keep this object
                System.out.println("inside filter "+ integer );
                return integer%2==1;
            }
        }).map(new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) {
                System.out.println("inside map "+ integer );
                  return integer*integer;
            }
        })
               .map(new Function<Integer, String>() {
                   @Override
                   public String apply(Integer integer) {
                       System.out.println("inside map again "+ integer );
                       return integer.toString()+"abcd";
                   }
               })
               .forEach(consumer);
//               .forEach(new Consumer<String>() {
//                   @Override
//                   public void accept(String s) {
//                       System.out.println(s);
//                   }
//               });

                       //{1,9,25} -> {1+9+25

//                .reduce(0, new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                System.out.println("inside reduce "+ integer + " "+ integer2);
//                return integer+integer2;
//            }
//        });

                       //using lambda expression
        int result = list.stream().filter(
                (a) -> {
                    return a%2==1;
                }
        ).map(
                (a) -> {
                    return a*a;
                }
        ).reduce(0 ,
                (a,b) -> {
            return a+b;
                }
                );

        System.out.println(result);







    }



}
