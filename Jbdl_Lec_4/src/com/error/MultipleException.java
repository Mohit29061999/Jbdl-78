package com.error;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultipleException {
    public static void main(String[] args)  {
        try {
            FileReader fileReader = new FileReader("dummy.txt");
        }



        //child
        catch(IOException e){

        }
//        catch(FileNotFoundException e){
//
//        }
//
        catch(Exception e){

        }
        //it will catch all the exception

    }
}
