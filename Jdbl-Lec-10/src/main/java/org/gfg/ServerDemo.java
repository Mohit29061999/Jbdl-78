package org.gfg;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerDemo {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        while(true){
            System.out.println("Enter some input");
            String currentInput = scanner.nextLine();
            if(currentInput.equalsIgnoreCase("exit")){
                break;
            }
            else{
                //main will not wait
                executorService.submit(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + " " + currentInput);
                    }
                });

                //main thread wait for executorService to finish its task
                executorService.awaitTermination(1000, TimeUnit.SECONDS);


            }
        }
    }
}
