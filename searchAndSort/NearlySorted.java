package searchAndSort;

import java.util.ArrayList;

public class NearlySorted {
	static ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(arr[0]);
        for(int i=1;i<num;i++){
            int j=i-1;
            while(j>=0 && arr[i] <= sorted.get(j)){
                j--;
            }
            j++;
            sorted.add(j,arr[i]);
        }
        return sorted;
    }
}
