//package com.error;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ThrowsException {
//
//    //public1 -> private -> private
//
//    //this exception can occur
//    public static void throwsException() throws IOException {
////        int a;
////        int b;
//        FileReader fileReader = new FileReader("dummy.txt");
//
//        try
//
//    {
//        //read file
//        fileReader.read();
//        // int y = a/b;
//        //it can cause exception
//        //code to read the file
//    } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        finally{
//            //do something for all cases
//            //exception and
//            fileReader.close();
//        }
//
////        catch(FileNotFoundException e){
////            //handle partial case here
////            System.out.println("file doesn't exist inside throws Exception");
////
////            //to tell this exception is coming
////            throw new FileNotFoundException();
////
////            //1. write code for creating the file
////
////            //inform user file isn't there
////            //2. System.out.println("file doesn't exist");
////        }
//    }
//
//    //dumb method and doesn't know how to handle exception
////    public static void throwsExceptionThirdMethod() throws  FileNotFoundException{
////        throwsException();
////    }
////
////    public static void throwsException() throws  FileNotFoundException{
////        FileReader fileReader = new FileReader("dummy.txt");
////    }
//
//    public static void main(String[] args) {
//        //Case 1: when child method just throws the exception
////       try {
////           throwsExceptionThirdMethod();
////       }
////
////       catch(FileNotFoundException e){
////           System.out.println("file doesn't exist");
////       }
//
//        //case 2: when child method deals with exception
//        //throwsException();
//
//        //case3: my method is partially smart
//        try{
//          //  throwsException();
//        }
////        catch(FileNotFoundException e){
////            //throw new FileNotFoundException();
////            System.out.println("file doesn't exist inside main");
////        }
//
//    }
//}
