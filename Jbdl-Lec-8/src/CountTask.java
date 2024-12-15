public class CountTask implements Runnable{
    //count variable is getting shared across all the threads
    private  static int count =0;


    //makes sure that only 1 threads enter this block at a time
    //but it slows down the system
    @Override
    public synchronized void run() {
       // try {
           // Thread.sleep(100);
       // Thread.currentThread().join();
            System.out.println("Currently counting");
            count++;
       // }
        /*catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */

    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        CountTask.count = count;
    }
}
