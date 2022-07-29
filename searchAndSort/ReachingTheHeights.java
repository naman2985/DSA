package searchAndSort;

import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/reaching-the-heights1921/1#

public class ReachingTheHeights {
	public static ArrayList<Integer> reaching_height (int n, int arr[]) {
        //Complete the function
        ArrayList<Integer> sorted = new ArrayList<>();
        int currFloor = 1;
        Arrays.sort(arr);
        for(int i=0;i<n/2;i++){
            sorted.add(arr[n-i-1]);
            currFloor += arr[n-i-1];
            sorted.add(arr[i]);
            currFloor -= arr[i];
            if(currFloor == 1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(-1);
                return temp;
            }
        }
        if(n % 2 != 0) sorted.add(arr[n/2]);
        return sorted;
    }
}
