package array;

import java.util.ArrayList;
import java.util.PriorityQueue;

// given k sorted arrays of size k merge them into a single sorted array 
public class MergeKSortedArrays {
	public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        ArrayList<Integer> sorted = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                pq.add(arr[i][j]);
            }
        }
        while(!pq.isEmpty()) sorted.add(pq.poll());
        return sorted;
    }
}
