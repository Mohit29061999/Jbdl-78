
//If a class implements that means
//it is a task that can be executed by a thread

/**
//using runnable:
 1. Create a class that implements runnable
 2. provide the task inside the run method of that class
 3. Create an instance of that class
 4. Create object of Thread class with above object
 5. Start the start
**/
public class Task implements Runnable {
    @Override
    public void run() {
      //Here specify the task to be executed
       // System.out.println("executing run method task");
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
