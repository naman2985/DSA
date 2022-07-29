package dp;

import java.util.Arrays;

public class MobileNumericKeypad {
	public static long getCount(int n){
		// Your code goes here
		long prev[] = new long[10];
		long curr[] = new long[10];
		Arrays.fill(prev, 1);
		for(int j=1;j<n;j++){
		    curr[0] = prev[8] + prev[0];
		    curr[8] += prev[0];
    		for(int i=1;i<=9;i++){
    		    curr[i] += prev[i];
    		    if(i % 3 != 1) curr[i] += prev[i-1];
    		    if(i > 3) curr[i] += prev[i-3];
    		    if(i % 3 != 0) curr[i] += prev[i+1];
    		    if(i <= 6) curr[i] += prev[i+3];
    		}
    		for(int i=0;i<=9;i++){
    		    prev[i] = curr[i];
    		}
    		Arrays.fill(curr,0);
		}
		
		long count = 0;
		for(int i=0;i<=9;i++) count += prev[i];
		return count;
	}
}
