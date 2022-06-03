/*
 * Given an array containing all the elements from 1 to a given number N. Every element is in the array only once except one element which is repeated.
 * Find the repeated element.
 */

package array;

public class OnlyRepeatedElementInAnArray {
	static int repeatedElement(int arr[],int n) {
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
		}
		return  sum - n*(n-1)/2;
	}
	public static void main(String[] args) {
		int arr[] = {3,4,1,2,7,2,5,6};
		System.out.println(repeatedElement(arr,8));
	}
}
