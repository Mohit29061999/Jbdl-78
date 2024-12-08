import java.util.concurrent.ThreadFactory;

//it is not used that much
public class ThreadFactoryDemo implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

    public static void main(String[] args){
        ThreadFactoryDemo threadFactoryDemo = new ThreadFactoryDemo();
        Task task = new Task();

        Thread thread1 = threadFactoryDemo.newThread(task);
        thread1.start();

        //Thread newThread = new Thread(task);
        Thread thread2 = threadFactoryDemo.newThread(task);


    }
}
