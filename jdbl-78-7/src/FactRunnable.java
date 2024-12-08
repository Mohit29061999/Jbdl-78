import java.util.concurrent.Callable;

public class FactRunnable implements Runnable{
    int x;

    public FactRunnable(int x) {
        this.x = x;
    }


    //Run method cannot return any value
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " starts");
        try {
            //adding a delay of 1000
            Thread.sleep(20);
            System.out.println(Factorial.factorial(x));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " end");

    }
}
