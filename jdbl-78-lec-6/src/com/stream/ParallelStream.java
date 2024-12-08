package com.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6);
        //ordering is guaranted
//        int sum = list.stream().filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        //condition on when to keep this object
//                        System.out.println("inside filter " + integer);
//                        return integer % 2 == 1;
//                    }
//                }).map(new Function<Integer, Integer>() {
//
//                    @Override
//                    public Integer apply(Integer integer) {
//                        System.out.println("inside map " + integer);
//                        return integer * integer;
//                    }
//                })
//                .reduce(0, new BinaryOperator<Integer>() {
//                    @Override
//                    public Integer apply(Integer integer, Integer integer2) {
//                        System.out.println("inside reduce "+integer + " "+integer2);
//                        return integer + integer2;
//                    }
//                });
//
//        System.out.println(sum);
//
//        System.out.println("//////////////////////////////////////////////////" +
//                "////////////");
//        System.out.println("//////////////////////////////////////////////////" +
//                "////////////");
//
//        //java will create multiple threads
//        //ordering is not guraranted
//         sum = list.parallelStream().filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        //condition on when to keep this object
//                        System.out.println("inside filter " + integer);
//                        return integer % 2 == 1;
//                    }
//                }).map(new Function<Integer, Integer>() {
//
//                    @Override
//                    public Integer apply(Integer integer) {
//                        System.out.println("inside map " + integer);
//                        return integer * integer;
//                    }
//                })
//                .reduce(0, new BinaryOperator<Integer>() {
//                    @Override
//                    public Integer apply(Integer integer, Integer integer2) {
//                        System.out.println("inside reduce "+integer + " "+integer2);
//                        return integer + integer2;
//                    }
//                });
//
//         System.out.println(sum);

        /**
         *  reduce(100,1) -> 99
         *  reduce(99,2) -> 97
         *  reduce(97,3) -> 94
         *  reduce(94,
          */


        int result = list.stream().reduce(100, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                //System.out.println("inside reduce " + integer + " "+integer2);
                return integer - integer2;
            }
        });

        System.out.println(result);

        //order is not
        int resultNew = list.parallelStream().reduce(100, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer - integer2;
            }
        });

        System.out.println(resultNew);



//        System.out.println("///////////////////////////////////");
//        //it will wait for 2 value atleast
//        Optional<Integer> resultNew  = list.stream().reduce(new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer integer, Integer integer2) {
//                System.out.println("inside reduce new" + integer + " "+integer2);
//                return  integer - integer2;
//            }
//        });

//       resultNew.get();

        //System.out.println(resultNew.get());




    }
}
