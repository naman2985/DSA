package array;

import java.util.PriorityQueue;

public class KLargestElementsOfAnArray {
	static int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size() > k) pq.poll();
        }
        int a[] = new int[k];
        for(int i=k-1;i>=0;i--) a[i] = pq.poll();
        return a;
    }
}
