// For a window having no negative integer print 0
package queue;
import java.util.*;
public class FirstNegativeIntegerInAWindowOfSizeK {
	static void firstNeg(int arr[],int n,int k) {
		Queue<Integer> q = new LinkedList<>();
		int i=0,j=0;
		while(j-i<k-1) {
			if(arr[j]<0) q.add(j);
			j++;
		}
		for(;j<n;i++,j++) {
			if(arr[j]<0) q.add(j);
			if(!q.isEmpty()) {
				System.out.print(arr[q.peek()]+" ");
				if(q.peek() == i) q.poll();
			}
			else System.out.print(0+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = {-8,2,3,-6,10};//-8 -6 -6 -6
		firstNeg(arr,5,3);
		
		firstNeg(arr,5,2);
	}
}
