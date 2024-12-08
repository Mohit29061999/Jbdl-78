import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//it is a pool of n threads

//2 advantage
//thread creation logic is done by ThreadPoolExecutor class
// thread management is done by ThreadPoolExecutor class
public class ThreadPoolDemo extends ThreadPoolExecutor {


    public ThreadPoolDemo(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static void main(String[] args) {
//        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo(
//                3,6,10,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(206)
//        );

//        Thread thread  = new Thread();

                ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo(
                3,6,10,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>()
        );

        List<Task> tasks = new ArrayList<>();
        for(int i=0;i<200;i++){
            Task task = new Task();
            tasks.add(task);
        }
        tasks.stream().forEach(
                (task) -> {
                    threadPoolDemo.submit(task);
                }
        );

        //stops thread pool from taking new task
        threadPoolDemo.shutdown();

        //stops thread pool completly
        //threadPoolDemo.shutdownNow();
        System.out.println("in main after shutdown");
//        tasks.stream().forEach(
//                (task) -> {
//                    threadPoolDemo.submit(task);
//                }
//        );


    }

}
