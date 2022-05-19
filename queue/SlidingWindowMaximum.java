package queue;
import java.util.*;
public class SlidingWindowMaximum {
	static void maxOfAllSubarrays(int[] arr,int n,int k) {
		Deque<Integer> q = new LinkedList<>();
		int i=0,j=1;
		q.addLast(0);
		for(;j<k-1;j++) {
			while(!q.isEmpty() && arr[q.getLast()]<=arr[j]) q.removeLast();
			q.addLast(j);
		}
		
		while(j<n) {
			while(!q.isEmpty() && arr[q.getLast()]<=arr[j]) q.removeLast();
			q.addLast(j);
			System.out.print(arr[q.getFirst()]+" ");
			if(q.getFirst() == i) q.removeFirst();
			i++;j++;
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,1,4,5,2,3,6};
		maxOfAllSubarrays(arr,9,3);
	}
}
