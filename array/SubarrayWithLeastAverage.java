package array;
// Given an array of size n, Find the subarray with least average of size k.
public class SubarrayWithLeastAverage {
	public static int least_average(int[] nums, int k)
    {
        // code here
        int i=0,sum=nums[0],j=0,leastIndex=0,n=nums.length;
        double least;
        while(j<k){
            sum += nums[j++];
        }
        least = sum /(double)k;
        while(j<n){
            sum += nums[j++];
            sum -= nums[i++];
            if(sum /(double)k < least){
                least = sum /(double)k;
                leastIndex = i;
            }
        }
        return leastIndex + 1;
    }
}
