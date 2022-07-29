package array;

/* Given an array Arr[] of N integers.
 * Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum
 */

public class LargestSumContiguousSubarray {
	int maxSubarraySum(int arr[], int n){
        // Your code here
        int currSum = 0,max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            currSum += arr[i];
            max = Math.max(max,currSum);
            if(currSum < 0)
                currSum = 0;
        }
        return max;
    }
}
