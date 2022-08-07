package array;

import java.util.Arrays;

// find the kth smallest element not present in the array
public class KthMex {
	static int kthMex(int n, int k, int arr[]) {
        // add your code here
        Arrays.sort(arr);
        int i = 0, j = -1;
        while(k > 0){
            j++;
            while(i<n && arr[i] < j) i++;
            if(i < n && arr[i] == j)
                while(i<n && arr[i] == j) i++;
            else k--;
        }
        return j;
    }
}
