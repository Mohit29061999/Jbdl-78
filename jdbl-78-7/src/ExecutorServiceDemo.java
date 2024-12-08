import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {

    public static void main(String[] args){
        //used a lot in code
      //  ExecutorService executorService = Executors.newFixedThreadPool(10);

        //create a single thread
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        //start with 0 thread and keep on creating a new thread as the task come
        //kill it if it is ideal for more than 60 seconds
        //a lot of short tasks(getting executed in really small time 5ms/10ms)
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Task> tasks = new ArrayList<>();
        for(int i=0;i<200;i++){
            Task task = new Task();
            tasks.add(task);
        }
        for(int i=0;i<200;i++){
            executorService.submit(tasks.get(i));
        }

        //inside finally block if we are using catch
        executorService.shutdown();

        //executorService.shutdownNow();



    }
}
