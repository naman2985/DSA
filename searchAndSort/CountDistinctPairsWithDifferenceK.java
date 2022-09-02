package searchAndSort;

import java.util.Arrays;

public class CountDistinctPairsWithDifferenceK {
	public static int totalPairs(int[] nums, int k)
    {
        // Code here
        Arrays.sort(nums);
        int n = nums.length;
        int pairs = 0;
        int i=0, j=1;
        while(j < n){
            if(Math.abs(nums[i] - nums[j]) == k){
                int temp = nums[j];
                while(j < n && nums[j] == temp) j++;
                pairs++;
                i++;
            }
            else if(Math.abs(nums[i] - nums[j]) < k)
                j++;
            else
                i++;
                
            if(i == j) j++;
        }
        return pairs;
    }
}
