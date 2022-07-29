package misc;

// leetcode #509

public class FibonacciNumber {
	public static int fib(int n) {
        int a=0,b=1,c=0;
        if(n==0) return a;
        if(n==1) return b;
        n-=2;
        while(n-->=0){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
