package array;

public class MaximumAverageSubarray {
	static int findMaxAverage(int[] arr, int n, int k) {
        // code here
        double maxAvg = 0;
        int start = 0, end = 0, sum = 0;
        int ans = 0;
        while(end < k)
            sum += arr[end++];
        maxAvg = sum /((double) k);
        while(end < n){
            sum -= arr[start++];
            sum += arr[end++];
            if(maxAvg < sum/((double) k)){
                maxAvg = sum/((double) k);
                ans = start;
            }
        }
        return ans;
    }
}
