public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo(){

    }

    //performance is an issue
    //one thread can execute the code at one time
    public static SingletonDemo getInstance(){
        if(instance == null){
            //synchronized should come here

            //it will give a performance boost after the object is created
            synchronized (SingletonDemo.class) {
                //we need to check instance again here
                //as some other thread might have updated it
                //before this
                if(instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }

        //if instance is already created
        //we will always come here
        return instance;
    }

}
