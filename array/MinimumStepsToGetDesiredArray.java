package array;
/*
 * Consider an array with N elements and value of all the elements is zero. We can perform following operations on the array.
 * 1. Incremental operations: Choose 1 element from the array and increment its value by 1.
 * 2. Doubling operation: Double the values of all the elements of array.
 * Given an array arr[] of integers of size N. 
 * Print the smallest possible number of operations needed to change the original array containing only zeroes to arr[].
 */
public class MinimumStepsToGetDesiredArray {
	static int countMinOperations(int[] arr, int n) {
        // code here
        int dec = 0, div = 0;
        for(int i=0;i<n;i++){
            int temp = 0;
            int x = arr[i];
            while(x > 0){
                if(x % 2 == 0){
                    temp++;
                    x /= 2;
                }
                else{
                    dec += 1;
                    x -= 1;
                }
            }
            div = Math.max(div, temp);
        }
        return dec + div;
    }
}
