package array;

import java.util.HashMap;
import java.util.Arrays;

public class MinimumSwapsToSort {
	public static int minSwaps(int nums[])
    {
        // Code here
        int swaps = 0;
        int n = nums.length;
        int arr[] = nums.clone();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(nums[i],i);
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(arr[i] != nums[i]){
                int j = map.get(nums[i]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                map.put(arr[i],i);
                map.put(arr[j],j);
                swaps++;
            }
        }
        //quickSort(nums,0,n-1);
        return swaps;
    }
}
