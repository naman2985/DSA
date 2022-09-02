package searchAndSort;

import java.util.Arrays;

public class SumOfTwoElementsWithSumNearestToZero {
	public static int closestToZero (int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        int left = 0, right = n-1;
        int sum = Integer.MAX_VALUE;
        while(left < right){
            int currSum = arr[right] + arr[left];
            if(Math.abs(currSum) < Math.abs(sum)){
                sum = currSum;
            }
            else if(Math.abs(currSum) == Math.abs(sum)){
                if(currSum > sum) sum = currSum;
            }
            if(currSum < 0) left++;
            else if(currSum == 0) return 0;
            else right--;
        }
        return sum;
    }
}
