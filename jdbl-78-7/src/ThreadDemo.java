import java.util.HashMap;

public class ThreadDemo extends Thread {
    int a;
    int b;

    public ThreadDemo(int a,int b){
        super();
        this.a=a;
        this.b=b;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(a+b);

    }
}
