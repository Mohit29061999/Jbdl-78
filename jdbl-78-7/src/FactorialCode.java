import java.util.ArrayList;
import java.util.List;

public class FactorialCode {

    public static void main(String[] args) throws InterruptedException {
        List<Integer > list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

//        for(int i=0;i<list.size();i++){
//            System.out.println(Factorial.factorial(list.get(i)));
//        }

        //stream class and to use lamdba expression
        Long currentTime = System.currentTimeMillis();
        list.stream().forEach(
                (i) -> {
                    System.out.println(Factorial.factorial(i));
                }
        );
         System.out.println("/////////////////////////////");
        Long end = System.currentTimeMillis();

        System.out.println(end - currentTime);

        System.out.println("/////////////////////////////");

        //empty list as of now
         List<Thread > threads = new ArrayList<>();
        list.stream().forEach(
                (i) -> {

                    //try {
                        Thread thread = new Thread(new FactRunnable(i));
                        thread.start();
//                    thread.start();

                        //it is getting populated here
                        threads.add(thread);
                        //wait for completion of this thread
                        //thread.join();
                        //process the response
//                   } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
        );

        System.out.println("threads created are "+ threads.size());
        for(int i=0;i<threads.size();i++){
            threads.get(i).join();
        }

        //main to reach here only if all threads has done execution
        System.out.println("inside main");






    }
}
