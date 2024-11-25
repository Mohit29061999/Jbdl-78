package com.error;

import java.io.Closeable;
import java.io.IOException;

public class AutoCloseable implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("close is called for AutoCloseable");
    }

    public void printData() throws Exception{
        System.out.println("print data is called");
    }

    public static void main(String[] args) throws IOException {
        AutoCloseable autoCloseable = new AutoCloseable();
//        try{
//            autoCloseable.printData();
//        }
//        catch(Exception e){
//
//        }
//        finally{
//            autoCloseable.close();
//        }

        //java will close this resource by itself
        try(autoCloseable){
            autoCloseable.printData();
        }
        catch(Exception e){

        }
    }
}
