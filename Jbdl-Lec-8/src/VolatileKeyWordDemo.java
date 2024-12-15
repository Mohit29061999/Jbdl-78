public class VolatileKeyWordDemo {
    private  volatile static boolean running = true;


    public static void main(String[] args) throws InterruptedException {
        //we are using lambada experssion
        Thread workerThread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        //it is rading from its local cache and
                        //hence the value is coming as true all the time
                        while (running) { // May read a stale value of `running`
                 //Simulate some work
            }
            System.out.println("Worker thread stopped.");}
                    }

//                () -> {
//            while (running) { // May read a stale value of `running`
//                // Simulate some work
//            }
//            System.out.println("Worker thread stopped.");}
        );


        workerThread.start();
//       synchronized (){
//           //only one thread can execute this code at a particular
//       }

        Thread.sleep(1000); // Allow workerThread to start and loop
        running = false;    // Main thread updates `running`
        System.out.println("Main thread set running to false.");
    }

}
