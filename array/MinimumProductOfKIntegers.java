package array;

import java.util.Arrays;

public class MinimumProductOfKIntegers {
	static int minProduct(int arr[], int n,int k)
    {
        // Complete the function
        Arrays.sort(arr);
        int prod = 1;
        for(int i=0;i<k;i++) prod = (int)(((long)prod * (long)arr[i]) % 1000000007L);
        return prod;
    }
}
