package array;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array arr[] of N distinct integers, output the array in such a way 
 * that the first element is first maximum and the second element is the first minimum, and so on.
 */
public class AlternativeSorting {
	static ArrayList<Long> alternateSort(long arr[] ,int n)
    {
        
        // Your code goes here
        Arrays.sort(arr);
        ArrayList<Long> alt = new ArrayList<>();
        int i = 0, j = n - 1;
        while(i < j){
            alt.add(arr[j--]);
            alt.add(arr[i++]);
        }
        if(i == j) alt.add(arr[i]);
        
        return alt;
    }
}
