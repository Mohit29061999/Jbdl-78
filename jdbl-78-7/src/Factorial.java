public class Factorial {
    public static Integer factorial(int x){
        int result =1;
        for(int i=2;i<=x;i++){
            result = result*i;
        }
        return result;
    }
}
