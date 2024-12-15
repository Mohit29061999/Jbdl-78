import java.util.concurrent.atomic.AtomicInteger;

public class CountTaskAtomic implements Runnable{

    //better than synchronized one
    //it is still allowing multi-threading
    //atomic uses volatile which makes sure that we read the value from the main memory only
    //volatile + atomic operation
    public  static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        //can i return value done by this thread
        //increase count by 1
        atomicInteger.getAndIncrement();

    }
}
