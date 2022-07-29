package misc;

// Given a number N. Check whether it is divisible by the sum of its digits or not

public class SumOfDigitsDivisibility {
	static int isDivisible(int n) {
        // code here
        int x = n,m=0;
        while(x>0){
            m += x % 10;
            x /= 10;
        }
        return n % m == 0?1:0;
    }
}
