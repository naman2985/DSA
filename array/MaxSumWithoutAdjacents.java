package array;

public class MaxSumWithoutAdjacents {
	static int findMaxSum(int arr[], int n) {
        // code here
        if(n == 1) return arr[0];
        if(n == 2) return Math.max(arr[0],arr[1]);
        arr[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            arr[i] = Math.max(arr[i-1], arr[i-2] + arr[i]);
        }
        return arr[n-1];
    }
}
