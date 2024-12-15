import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
       // CountTask countTask = new CountTask();
        CountTaskAtomic countTaskAtomic = new CountTaskAtomic();

        //other thread keeping count is still running
        for(int i=0;i<200000;i++){
            executorService.submit(countTaskAtomic);

        }

        executorService.shutdown();

        //it will wait for amount of time passed to all the task to get executed
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        //you are already printing the value
        System.out.println("Counting ends here");
        System.out.println(CountTaskAtomic.atomicInteger); //main thread
    }
}