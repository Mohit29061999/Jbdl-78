package com;

import java.util.Iterator;

public class IterableDemo implements Iterable<String>{

    String[] arr = new String[10];


    @Override
    public Iterator<String> iterator() {
     return new MyIterator(0);
    }

    public class MyIterator implements Iterator<String>{
         int index = 0;

        public MyIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
        return arr[index]!=null && index<10;
           // return index<1;
        }

        @Override
        public String next() {
           String current = arr[index];
           index++;
           return current;
        }
    }

    public static void main(String[] args){
        IterableDemo iterableDemo = new IterableDemo();
        iterableDemo.arr[0]="abcd";
        iterableDemo.arr[1]="def";
        iterableDemo.arr[2]="ghi";


        //to give unfiormaity
        Iterator<String> iterator = iterableDemo.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
