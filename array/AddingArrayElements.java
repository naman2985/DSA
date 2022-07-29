package array;

import java.util.PriorityQueue;

/*
 * Given an array Arr[] of size N and an integer K, you have to add the sum of two minimum elements of the array to the array
 * until all the elements are greater than or equal to K and find the number of such operations required.
 */
public class AddingArrayElements {
	static int minOperations(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr)
            pq.add(i);
            
        int ops = 0;
        while(pq.peek() < k){
            int a = pq.poll();
            if(pq.isEmpty()) return -1;
            int b = pq.poll();
            pq.add(a + b);
            ops++;
        }
        return ops;
    }
}
