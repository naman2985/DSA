package array;

import java.util.Arrays;

public class LengthUnsortedSubarray {
	static int[] printUnsorted(int[] arr, int n) {
        // code here
        int nums[] = arr.clone(), ans[] = new int[2];
        int i = 0;
        Arrays.sort(arr);
        while(i < n && nums[i] == arr[i]) i++;
        if(i == n){
            ans[0] = 0;
            ans[1] = 0;
            return ans;
        }
        ans[0] = i;
        i = n-1;
        while(i > 0 && nums[i] == arr[i]) i--;
        ans[1] = i;
        return ans;
    }
}
