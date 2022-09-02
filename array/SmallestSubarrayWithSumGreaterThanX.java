package array;

public class SmallestSubarrayWithSumGreaterThanX {
	public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        int smallest = Integer.MAX_VALUE, start = 0,end = 0, sum = a[0];
        while(end < n){
            if(sum <= x){
                end++;
                if(end < n) sum += a[end];
            }
            else{
                smallest = Math.min(smallest, end - start + 1);
                sum -= a[start];
                start++;
                end = Math.max(start, end);
            }
        }
        return smallest;
    }
}
