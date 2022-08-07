package array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	static public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int arr[]:matrix){
            for(int i:arr){
                pq.add(i);
                if(pq.size() > k) pq.poll();
            }
        }
        return pq.poll();
    }
}
