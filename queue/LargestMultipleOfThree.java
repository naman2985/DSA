/*
 * Given an array of non-negative integers. FInd the largest multiple of 3 that can be formed from array elements.
 * Eg: For {8,9,1}, it should be 981
 */
package queue;
import java.util.*;
public class LargestMultipleOfThree {
	static int populateAux(int aux[],Queue<Integer> q1,Queue<Integer> q2,Queue<Integer> q3) {
		int top = 0;
		while(!q1.isEmpty()) {
			aux[top++] = q1.remove();
		}
		while(!q2.isEmpty()) {
			aux[top++] = q2.remove();
		}
		while(!q3.isEmpty()) {
			aux[top++] = q3.remove();
		}
		return top;
	}
	
	static boolean largestMultiple(int[] arr,int n) {
		Arrays.sort(arr);
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		Queue<Integer> q3 = new LinkedList<>();
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(arr[i]%3 == 0)
				q1.add(arr[i]);
			else if(arr[i]%3 == 1)
				q2.add(arr[i]);
			else q3.add(arr[i]);
		}
		if(sum%3 == 1) {
			if(!q2.isEmpty()) q2.remove();
			else {
				if(q3.size()<2) return false;
				q3.remove();
				q3.remove();
			}
		}
		else if(sum%3 == 2) {
			if(!q3.isEmpty()) q3.remove();
			else {
				if(q2.size()<2) return false;
				q2.remove();
				q2.remove();
			}
		}
		int[] aux = new int[n];
		int top = populateAux(aux,q1,q2,q3);
		Arrays.sort(aux,0,top);
		for(int i=top-1;i>=0;i--) System.out.print(aux[i]+" ");
		return true;
	}
	public static void main(String[] args) {
		int arr[] = {6,1,0,8,7};
		if(!largestMultiple(arr,5))
			System.out.println("No multiple of three can be formed");
	}
}
