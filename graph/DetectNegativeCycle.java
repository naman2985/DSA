package graph;

import java.util.Arrays;
// Using Bellman Ford
public class DetectNegativeCycle {
	static int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int v=0;v<n-1;v++){
            for(int[] u:edges){
                int x=u[0],y=u[1],z=u[2];
                if(dist[y]>((Integer.MAX_VALUE==dist[x])?dist[x]:dist[x]+z)){
                    dist[y]=dist[x]+z;
                }
            }
        }
        for(int[] u:edges){
            int x=u[0],y=u[1],z=u[2];
            if(dist[y]>((Integer.MAX_VALUE==dist[x])?dist[x]:dist[x]+z)){
                return 1;
            }
        }
        return 0;
    }
}
