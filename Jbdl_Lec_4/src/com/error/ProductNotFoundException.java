package com.error;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        System.out.println(message);
    }

    public static void  main(String[] args) throws ProductNotFoundException{
        String prodId = "abcd";
        throw new ProductNotFoundException("Product with id "+ prodId+ " doesn't exist");
    }
}
