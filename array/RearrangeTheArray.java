package array;

import java.util.Arrays;

/*
 * Given an array arr of n integers, task is to print the array in the order –
 *  smallest number, largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on.
 */
public class RearrangeTheArray {
	static void rearrangeArray(int[] arr, int n) {
        // code here
        int newArr[] = new int[n];
        Arrays.sort(arr);
        int i=0, j=n-1,k=0;
        while(i < j){
            newArr[k++] = arr[i++];
            newArr[k++] = arr[j--];
        }
        if(n % 2 == 1) newArr[k] = arr[i];
        for(i=0;i<n;i++) arr[i] = newArr[i];
    }
}
