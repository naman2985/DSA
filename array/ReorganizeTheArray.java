package array;

import java.util.Arrays;
/*
 * Given an array of elements of length N, ranging from 0 to N-1,
 * your task is to write a program that rearranges the elements of the array. 
 * All elements may not be present in the array, if the element is not present 
 * then there will be -1 present in the array. 
 * Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
 */
public class ReorganizeTheArray {
	public static int[] Rearrange (int arr[], int n) {
        // Complete the function
        int []rearranged = new int[n];
        Arrays.fill(rearranged,-1);
        for(int i:arr){
            if(i != -1)
                rearranged[i] = i;
        }
        return rearranged;
    }
}
