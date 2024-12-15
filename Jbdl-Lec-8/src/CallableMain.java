import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //this is variable that will get the value in sometime in future
        Future<String> val = executorService.submit(callableDemo);

//        if(val.isDone()) {
//            //we will get value after 10000 ms
//            System.out.println(val.get());
//        }
//        else{
//            System.out.println("value isn't there yet");
//        }

        while(val.isDone()==false){
          /// wait for future variable to get the value
        }
        System.out.println(val.get());

    }
}
