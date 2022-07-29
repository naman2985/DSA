package misc;

public class NumberThatAreNotDivisible {
	static Long noOfNumbers(Long n) {
        // code here
        long m = 0;
        m += n/(long)7 - n/(long)14 - n/(long)21 - n/(long)35 + n/(long)42 + n/(long)70 + n/(long)105 - n/(long)210;
        m += n/(long) 5 - n / (long) 10 - n / (long) 15 + n / (long) 30;
        m += n /(long) 3 - n/(long) 6; 
        m += n/(long) 2;
        return n - m;
    }
}
