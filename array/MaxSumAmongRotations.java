package array;
/*
 * Given an array(0-based indexing), you have to find the max sum of i*A[i] 
 * where A[i] is the element at index i in the array. 
 * The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.
 */
public class MaxSumAmongRotations {
	int max_sum(int arr[], int n)
    {
	    int currSum=0,sum=0;
	    for(int i=0;i<n;i++){
	        currSum+=i*arr[i];
	        sum+=arr[i];
	    }
	    int minSum=currSum;
	    for(int i=0;i<n-1;i++){
	        currSum=currSum-sum+n*arr[i];
	        minSum=Math.max(minSum,currSum);
	    }
	    return minSum;
    }
}
