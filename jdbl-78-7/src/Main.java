public class Main {
    public static void main(String[] args) {

        //by default  main thread gets created
        //and all task are done by this thread
        //System.out.println(Thread.currentThread().getName());
//
//        ThreadDemo threadDemo = new ThreadDemo(4,5);
//
//        //it will call the run method
//        threadDemo.start();
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();


        ThreadDemo threadDemo2 = new ThreadDemo(2,3);
        threadDemo2.start();

        Thread thread2 = new Thread(task);
        thread2.start();

        for(int i=0;i<100;i++){
            Thread currentThread = new Thread(task);
            currentThread.start();
        }

    }
}