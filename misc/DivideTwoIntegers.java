package misc;
/*
 * Leetcode #29
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * 
 * Keep in Mind:
 * if dividend = Integer.MIN_VALUE and divisor == -1 return Integer.MAX_VALUE
 * if divisor == Integer.MIX_VALUE and dividend > Integer.MIN_VALUE return 0
 * 
 * Rest of the cases were easy to figure out and solve  
 */
public class DivideTwoIntegers {
	static int abs(int a){
        return (a<0)?-a:a;
    }
    static boolean canContinue(int a,int b){
        if(b == Integer.MIN_VALUE){
            return true;
        } else if(a == Integer.MIN_VALUE) return false;
        else if(abs(a)<=abs(b)) return true;
        return false;
    }
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE){
            if(divisor == Integer.MIN_VALUE) return 1;
            if(divisor == -1) return Integer.MAX_VALUE;
        }
        int quotient=0, target=dividend;
        int sign=(dividend<0)?-1:1;
        while(canContinue(divisor,target)){
            int temp=abs(divisor),steps=1;
            while(abs(temp) < abs(target-sign*temp)){
                temp+=temp;
                steps+=steps;
            }
            target-=sign*abs(temp);
            quotient+=steps;
        }
        sign = ((dividend<0 && divisor>0) || (dividend>0 && divisor<0))?-1:1;
        return sign*quotient;
    }
}
