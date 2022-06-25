package queue;
// Leetcode # 1642
import java.util.PriorityQueue;
import java.util.Collections;

public class FurthestBuildingYouCanReach {
	static public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=heights.length;
        for(int i=1;i<n;i++){
            int diff=heights[i]-heights[i-1];
            if(diff>0){
                bricks-=diff;
                pq.add(diff);
                if(bricks<0){
                    bricks+=pq.poll();
                    if(ladders>0) ladders--;
                    else return i-1;
                }
            }
        }
        return n-1;
    }
}
