package interviews.Other;

public class Fibonacci {
    public int Fibonacci(int n) {
        if(n==1||n==0){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
